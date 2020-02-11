package work.student_dashboard.backend.payloads;

import work.student_dashboard.backend.entity.Grades;

public class GetGradesResponse {
	
	private long id;
	private String subjectName;
	private Grades grade;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Grades getGrade() {
		return grade;
	}
	public void setGrade(Grades grade) {
		this.grade = grade;
	}
	public GetGradesResponse(long id, String subjectName, Grades grade) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.grade = grade;
	}
	public GetGradesResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
