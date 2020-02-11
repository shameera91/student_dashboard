package work.student_dashboard.backend.payloads;

import java.sql.Date;

import work.student_dashboard.backend.entity.AttendanceType;

public class MarkAttendanceRequest {
	
	private Date date;
	private long studentId;
	private AttendanceType attendanceType;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public AttendanceType getAttendanceType() {
		return attendanceType;
	}
	public void setAttendanceType(AttendanceType attendanceType) {
		this.attendanceType = attendanceType;
	}
	public MarkAttendanceRequest(Date date, int studentId, AttendanceType attendanceType) {
		super();
		this.date = date;
		this.studentId = studentId;
		this.attendanceType = attendanceType;
	}
	public MarkAttendanceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
