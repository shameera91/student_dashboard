package work.student_dashboard.backend.payloads;


import java.util.Date;

import work.student_dashboard.backend.entity.AttendanceType;

public class ViewAttendanceResponse {
	
	private String studentId;
	private String studentFirstName;
	private String studentLastName;
	private String studentYear;
	private Date attendanceDate;
	private String attendancetype;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getStudentYear() {
		return studentYear;
	}
	public void setStudentYear(String studentYear) {
		this.studentYear = studentYear;
	}
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getAttendancetype() {
		return attendancetype;
	}
	public void setAttendancetype(String attendancetype) {
		this.attendancetype = attendancetype;
	}
	public ViewAttendanceResponse(String studentId, String studentFirstName, String studentLastName, String studentYear,
			Date attendanceDate, String attendancetype) {
		super();
		this.studentId = studentId;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentYear = studentYear;
		this.attendanceDate = attendanceDate;
		this.attendancetype = attendancetype;
	}
	public ViewAttendanceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
