package work.student_dashboard.backend.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "students")
public class Student extends UserDateAudit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "student_id")
	@Size(max = 100)
	private String studentId;
	
	@Column(name = "student_first_name")
	@Size(max = 100)
	private String studentFirstName;
	
	@Column(name = "student_last_name")
	@Size(max = 100)
	private String studentLastName;
	
	@Column(name = "student_year")
	@Size(max = 100)
	private String studentYear;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

		
	
	


	public Student(@Size(max = 100) String studentId, @Size(max = 100) String studentFirstName,
			@Size(max = 100) String studentLastName, @Size(max = 100) String studentYear) {
		super();
		this.studentId = studentId;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentYear = studentYear;
	}


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


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
