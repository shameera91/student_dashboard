package work.student_dashboard.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import work.student_dashboard.backend.entity.Assignment;
import work.student_dashboard.backend.entity.AssignmentMarks;
import work.student_dashboard.backend.entity.Grades;
import work.student_dashboard.backend.entity.Student;
import work.student_dashboard.backend.entity.Subject;
import work.student_dashboard.backend.payloads.AddAssignmentRequest;
import work.student_dashboard.backend.payloads.AddMarksRequest;
import work.student_dashboard.backend.payloads.ApiResponse;
import work.student_dashboard.backend.payloads.AssignmentResponse;
import work.student_dashboard.backend.payloads.SubjectResponse;
import work.student_dashboard.backend.repository.AssignmentMarksRepository;
import work.student_dashboard.backend.repository.AssignmentRepository;
import work.student_dashboard.backend.repository.StudentRepository;
import work.student_dashboard.backend.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AssignmentMarksRepository assignmentMarksRepository;

    public ResponseEntity<?> createAssignment(AddAssignmentRequest assignmentRequest) {


        if (assignmentRepository.existsByAssignmentCode(assignmentRequest.getAssignmentCode())) {
            return new ResponseEntity<ApiResponse>
                    (new ApiResponse(false, "assignment already exists in the system."),
                            HttpStatus.BAD_REQUEST);
        }

        Subject subject = subjectRepository.findById(assignmentRequest.getSubjectId()).get();
        Assignment assignment = new Assignment();
        assignment.setAssignmentCode(assignmentRequest.getAssignmentCode());
        assignment.setAssignmentName(assignmentRequest.getAssignmentName());
        assignment.setSemester(assignmentRequest.getSemester());
        assignment.setSubject(subject);
        assignmentRepository.save(assignment);

        return new ResponseEntity<ApiResponse>(new ApiResponse
                (true, "assignment saved in the system."), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<?> getAllAssignments() {
        List<Assignment> allAssignments = assignmentRepository.findAll();
        List<AssignmentResponse> result = new ArrayList<>();
        allAssignments.stream().forEach(a -> {
            result.add(new AssignmentResponse(a.getId(), a.getAssignmentCode(), a.getAssignmentName(),
                    a.getSemester(), a.getSubject().getSubjectName()));
        });
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> getAssignmentsBySemester(int semester) {
        List<AssignmentResponse> assignmentResponseList = new ArrayList<>();
        List<Assignment> allBySemester = assignmentRepository.getAllBySemester(semester);
        allBySemester.stream().forEach(a -> {
            assignmentResponseList.add(new AssignmentResponse(a.getId(), a.getAssignmentCode(), a.getAssignmentName(),
                    a.getSemester(), a.getSubject().getSubjectName()));
        });
        return ResponseEntity.ok(assignmentResponseList);
    }

    public ResponseEntity<?> addAssignmentMarks(List<AddMarksRequest> addMarksRequest, String studentId) {
        List<AssignmentMarks> assignmentMarks = new ArrayList<>();
        Student student = studentRepository.findByStudentId(studentId).get();

        /*validation*/
       /* if (assignmentMarksRepository.existsByStudentAndAssignment(student,)) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Marks  is already added for this student"),
                    HttpStatus.BAD_REQUEST);
        }*/

        addMarksRequest.stream().forEach(marksRequest -> {
            AssignmentMarks obj = new AssignmentMarks();
            obj.setMarks(marksRequest.getMarks());
            obj.setStudent(student);
            obj.setAssignment(assignmentRepository.findById(marksRequest.getAssignmentId()).get());
            assignmentMarks.add(obj);
        });
        return ResponseEntity.ok(assignmentMarksRepository.saveAll(assignmentMarks));
    }

    public ResponseEntity<?> getStudentGradeBySemesterAndSubject(int semester, String studentId) {
        List<SubjectResponse> subjectResponse = new ArrayList<>();
        List<Subject> allSubjects = subjectRepository.findAll();
        Student student = studentRepository.findByStudentId(studentId).get();


        for (Subject s : allSubjects) {
            List<Assignment> allBySemester = assignmentRepository.getAllBySemesterAndSubject(semester, s);
            Integer assignmentCount = allBySemester.size();
            SubjectResponse obj = new SubjectResponse();
            obj.setSubjectId(s.getId());
            obj.setSubjectName(s.getSubjectName());

            Integer sumOfAssignments = assignmentMarksRepository.getStudentGradeBySemesterAndSubject(semester, s.getId(), student.getId());

            Integer avgMarksForSubject = sumOfAssignments / assignmentCount;

            if (avgMarksForSubject <= 100 && avgMarksForSubject > 75) {
                obj.setResult(Grades.A);
            } else if (avgMarksForSubject <= 75 && avgMarksForSubject > 65) {
                obj.setResult(Grades.B);
            } else if (avgMarksForSubject <= 65 && avgMarksForSubject > 55) {
                obj.setResult(Grades.C);
            } else if (avgMarksForSubject <= 55 && avgMarksForSubject > 45) {
                obj.setResult(Grades.D);
            } else if (avgMarksForSubject <= 45 && avgMarksForSubject > 35) {
                obj.setResult(Grades.E);
            } else {
                obj.setResult(Grades.F);
            }

            subjectResponse.add(obj);

        }

        return ResponseEntity.ok(subjectResponse);
    }
}
