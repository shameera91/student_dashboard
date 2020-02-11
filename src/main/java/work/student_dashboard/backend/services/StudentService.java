package work.student_dashboard.backend.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import work.student_dashboard.backend.entity.Attendance;
import work.student_dashboard.backend.entity.Student;
import work.student_dashboard.backend.payloads.ApiResponse;
import work.student_dashboard.backend.repository.AttendanceRepository;
import work.student_dashboard.backend.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AttendanceRepository attendanceRepository;

	@Transactional
	public ResponseEntity<ApiResponse> createStudent(Student student) {

		if (studentRepository.existsByStudentId(student.getStudentId())) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "student already exists in the system."),
					HttpStatus.BAD_REQUEST);
		}
		student.setId(0);
		studentRepository.save(student);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "student saved in the system."),
				HttpStatus.ACCEPTED);
	}
	
	@Transactional
	public ResponseEntity<?> getAllStudents() {
		return ResponseEntity.ok(studentRepository.findAll());
	}

	@Transactional
	public ResponseEntity<?> getUnmarkedStudetsForTheDate(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		Calendar calendarii = Calendar.getInstance();
		calendarii.setTime(date);
		calendarii.set(Calendar.HOUR_OF_DAY, 23);

		List<Attendance> attendanceList = attendanceRepository.getAllBetweenDates(calendar.getTime(),
				calendarii.getTime());

		List<Long> MarkedStudentList = new ArrayList<>();
		MarkedStudentList.add((long) 0);
		for (Attendance attendance : attendanceList) {

			MarkedStudentList.add(attendance.getStudent().getId());
		}
		return ResponseEntity.ok(studentRepository.findByIdNotIn(MarkedStudentList));
	}

}
