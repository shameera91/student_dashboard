package work.student_dashboard.backend.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "attendance")
public class Attendance extends UserDateAudit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "student_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Student student;
	
	 @Temporal(TemporalType.DATE)
	@Column(name = "attendance_Date")
	private Date attendanceDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "attendance_type")
	private AttendanceType attendancetype;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public AttendanceType getAttendancetype() {
		return attendancetype;
	}

	public void setAttendancetype(AttendanceType attendancetype) {
		this.attendancetype = attendancetype;
	}

	public Attendance(Student student, @Size(max = 100) Date attendanceDate, AttendanceType attendancetype) {
		super();
		this.student = student;
		this.attendanceDate = attendanceDate;
		this.attendancetype = attendancetype;
	}

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", student=" + student + ", attendanceDate=" + attendanceDate
				+ ", attendancetype=" + attendancetype + "]";
	}
	
	
	
	
}
