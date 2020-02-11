package work.student_dashboard.backend.payloads;

import work.student_dashboard.backend.entity.Grades;

public class SubjectResponse {

    private long subjectId;
    private String subjectName;
    private Grades result;

    public SubjectResponse() {
    }

    public SubjectResponse(long subjectId, String subjectName, Grades result) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.result = result;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

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
}
