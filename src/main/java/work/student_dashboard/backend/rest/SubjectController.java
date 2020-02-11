package work.student_dashboard.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.student_dashboard.backend.entity.Subject;
import work.student_dashboard.backend.services.SubjectService;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/subject")
@CrossOrigin
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createInvoice(@Valid @RequestBody Subject subject) throws Exception {
		return subjectService.createSubject(subject);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllSubjects() throws Exception {
		return subjectService.getAllSubjects();
	}
}
