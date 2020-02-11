package work.student_dashboard.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "full_name")
	@Size(max = 100)
	private String fullName;

	

	@Column(name = "email")
	@Size(max = 100)
	private String email;

	@Column(name = "password")
	@Size(max = 100)
	@JsonIgnore
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private RoleName role;
	
	@Column(name = "pro_pic")
	private String proPic;

	
	public String getProPic() {
		return proPic;
	}

	public void setProPic(String proPic) {
		this.proPic = proPic;
	}

	public RoleName getRole() {
		return role;
	}

	public void setRole(RoleName role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public User() {

	}

	public User(@Size(max = 100) String fullName, @Size(max = 100) String email,
			@Size(max = 100) String password, RoleName role) {
		super();
		
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.role = role;
		
	}
	
	

}
