package work.student_dashboard.backend.rest;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.student_dashboard.backend.entity.Student;
import work.student_dashboard.backend.services.StudentService;



@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createStudent(@Valid @RequestBody Student student) throws Exception {
		return studentService.createStudent(student);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllStudents() throws Exception {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/get-unmarked")
	public ResponseEntity<?> getUnmarkedStudetsForTheDate(@RequestParam String date) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date datem= null;
	    try {
	        java.util.Date utilDate = format.parse(date);
	        datem  = new java.sql.Date(utilDate.getTime());
	        
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    System.out.println(datem);
		return studentService.getUnmarkedStudetsForTheDate(datem);
	}

}
