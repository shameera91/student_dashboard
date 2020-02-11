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
import work.student_dashboard.backend.payloads.AddGradesRequest;
import work.student_dashboard.backend.services.GradesService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/grade")
@CrossOrigin
public class GradesController {

    @Autowired
    GradesService gradesService;

    @PostMapping("/create/{studentId}/{year}/{semester}")
    public ResponseEntity<?> createGrade(@Valid @RequestBody List<AddGradesRequest> addGradeRequest,
                                         @PathVariable String studentId, @PathVariable String year,
                                         @PathVariable int semester) throws Exception {
        return gradesService.createGrades(addGradeRequest, studentId, year, semester);

    }

    @GetMapping("/get/{studentId}/{year}/{semester}")
    public ResponseEntity<?> getGrades(@PathVariable String studentId, @PathVariable String year,
                                       @PathVariable int semester) throws Exception {
        return gradesService.getGrades(studentId, year, semester);
    }

}
