package work.student_dashboard.backend.payloads;

public class AssignmentResponse {

    private long id;
    private String assignmentCode;
    private String assignmentName;
    private int semester;
    private String subjectName;

    public AssignmentResponse() {
    }

    public AssignmentResponse(long id, String assignmentCode, String assignmentName, int semester, String subjectName) {
        this.id = id;
        this.assignmentCode = assignmentCode;
        this.assignmentName = assignmentName;
        this.semester = semester;
        this.subjectName = subjectName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAssignmentCode() {
        return assignmentCode;
    }

    public void setAssignmentCode(String assignmentCode) {
        this.assignmentCode = assignmentCode;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
