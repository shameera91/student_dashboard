package work.student_dashboard.backend.payloads;

/**
 * Created By Shameera.A on 2/9/2020
 */
public class AddAssignmentRequest {

    private String assignmentCode;
    private String assignmentName;
    private int semester;
    private long subjectId;

    public AddAssignmentRequest() {
    }

    public AddAssignmentRequest(String assignmentCode, String assignmentName, int semester, long subjectId) {
        this.assignmentCode = assignmentCode;
        this.assignmentName = assignmentName;
        this.semester = semester;
        this.subjectId = subjectId;
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

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }
}
