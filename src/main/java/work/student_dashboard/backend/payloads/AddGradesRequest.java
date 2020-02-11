package work.student_dashboard.backend.payloads;

import work.student_dashboard.backend.entity.Grades;

public class AddGradesRequest {
	
	private long subjectId;
	private Grades result;
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public Grades getResult() {
		return result;
	}
	public void setResult(Grades result) {
		this.result = result;
	}
	public AddGradesRequest(long subjectId, Grades result) {
		super();
		this.subjectId = subjectId;
		this.result = result;
	}
	public AddGradesRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
