package work.student_dashboard.backend.rest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import work.student_dashboard.backend.payloads.MarkAttendanceRequest;
import work.student_dashboard.backend.services.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin
public class AttendanceController {
	
	
	@Autowired
	AttendanceService attendanceService;
	
	
	@PostMapping("/mark")
	public ResponseEntity<?> markAttendance(@Valid @RequestBody MarkAttendanceRequest markAttendanceRequest) throws Exception {
		return attendanceService.markAttendance(markAttendanceRequest);
	}
	
	
	@GetMapping("/view-attendance")
	public ResponseEntity<?> viewAttendance() throws Exception {
		return attendanceService.viewAttendance();
	}
	
}
