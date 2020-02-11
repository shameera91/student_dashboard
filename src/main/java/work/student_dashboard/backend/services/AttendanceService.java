package work.student_dashboard.backend.services;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import work.student_dashboard.backend.entity.Attendance;
import work.student_dashboard.backend.entity.AttendanceType;
import work.student_dashboard.backend.entity.Student;
import work.student_dashboard.backend.payloads.ApiResponse;
import work.student_dashboard.backend.payloads.MarkAttendanceRequest;
import work.student_dashboard.backend.payloads.ViewAttendanceResponse;
import work.student_dashboard.backend.repository.AttendanceRepository;
import work.student_dashboard.backend.repository.StudentRepository;

@Service
public class AttendanceService {

	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Transactional
	public ResponseEntity<?> markAttendance(MarkAttendanceRequest markAttendanceRequest) throws Exception {
	
		
		Attendance attendance = new Attendance();
		Student student = studentRepository.findById(markAttendanceRequest.getStudentId()).get();
		attendance.setStudent(student);
		attendance.setAttendanceDate(markAttendanceRequest.getDate());
		attendance.setAttendancetype(markAttendanceRequest.getAttendanceType());
		attendanceRepository.save(attendance);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "studnet attendance marked."),
				HttpStatus.ACCEPTED);
	}
	
	@Transactional
	public ResponseEntity<?> viewAttendance(){
		List<Attendance> attendanceList =  attendanceRepository.findAll();
		List<ViewAttendanceResponse> viewAttendanceListResponse= new ArrayList<>();
		for (Attendance attendance : attendanceList) {
			
			String atype = attendance.getAttendancetype() == AttendanceType.TYPE_ABSENT ? "Absent" : "Present";
			
			viewAttendanceListResponse.add(new ViewAttendanceResponse(
					attendance.getStudent().getStudentId(),
					attendance.getStudent().getStudentFirstName(),
					attendance.getStudent().getStudentLastName(),
					attendance.getStudent().getStudentYear(),
					attendance.getAttendanceDate(),
					atype));
		}	
		return  ResponseEntity.ok(viewAttendanceListResponse);
	}
	
	
}
