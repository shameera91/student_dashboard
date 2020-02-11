package work.student_dashboard.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import work.student_dashboard.backend.entity.Attendance;
import work.student_dashboard.backend.entity.Grade;
import work.student_dashboard.backend.entity.Student;
import work.student_dashboard.backend.entity.Subject;
import work.student_dashboard.backend.payloads.AddGradesRequest;
import work.student_dashboard.backend.payloads.ApiResponse;
import work.student_dashboard.backend.payloads.GetGradesResponse;
import work.student_dashboard.backend.repository.GradeRepository;
import work.student_dashboard.backend.repository.StudentRepository;
import work.student_dashboard.backend.repository.SubjectRepository;

@Service
public class GradesService {

	@Autowired
	GradeRepository gradeRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Transactional
	public ResponseEntity<ApiResponse> createGrades(List<AddGradesRequest> addGradeRequest, String studentId,
			String year, int semester) {

		Student student = studentRepository.findByStudentId(studentId).get();
		if (gradeRepository.existsByYearAndSemesterAndStudent(year, semester, student)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Result is alredy added for this semester"),
					HttpStatus.BAD_REQUEST);
		}

		for (AddGradesRequest requestn : addGradeRequest) {
			Subject subject = subjectRepository.findById(requestn.getSubjectId()).get();
			Grade grade = new Grade();
			grade.setGrade(requestn.getResult());
			grade.setStudent(student);
			grade.setSubject(subject);
			grade.setSemester(semester);
			grade.setYear(year);
			gradeRepository.save(grade);
		}

		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Grades saved in the system."),
				HttpStatus.ACCEPTED);
	}
	
	@Transactional
	public ResponseEntity<?> getGrades(String studentId, String year, int semester) {
		Student student = studentRepository.findByStudentId(studentId).get();
		List<Grade> grades = gradeRepository.findByYearAndSemesterAndStudent(year, semester, student);

		List<GetGradesResponse> response = new ArrayList<>();

		for (Grade grade : grades) {

			response.add(new GetGradesResponse(grade.getId(), grade.getSubject().getSubjectName(), grade.getGrade()));
		}

		return ResponseEntity.ok(response);

	}
}
