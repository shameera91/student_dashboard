package work.student_dashboard.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.student_dashboard.backend.payloads.AddAssignmentRequest;
import work.student_dashboard.backend.payloads.AddMarksRequest;
import work.student_dashboard.backend.services.AssignmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/assignment")
@CrossOrigin
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    /*@PreAuthorize("hasRole('ADMIN')")*/
    @PostMapping("/create")
    public ResponseEntity<?> createAssignment(@Valid @RequestBody AddAssignmentRequest assignment) {
        return assignmentService.createAssignment(assignment);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/get-assignment/{semester}")
    public ResponseEntity<?> getAssignmentsBySemester(@PathVariable int semester) {
        return assignmentService.getAssignmentsBySemester(semester);
    }

    @PostMapping("/save-marks/{studentId}")
    public ResponseEntity<?> saveAssignmentMarks(@RequestBody List<AddMarksRequest> addMarksRequest,
                                                 @PathVariable String studentId) {
        return assignmentService.addAssignmentMarks(addMarksRequest, studentId);
    }

    @GetMapping("/get-grade/{semester}/{studentId}")
    public ResponseEntity<?> getStudentGradeBySemesterAndSubject(@PathVariable int semester,
                                                                 @PathVariable String studentId) {
        return assignmentService.getStudentGradeBySemesterAndSubject(semester,studentId);
    }

}
