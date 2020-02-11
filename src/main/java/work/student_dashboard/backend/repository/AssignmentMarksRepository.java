package work.student_dashboard.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import work.student_dashboard.backend.entity.Assignment;
import work.student_dashboard.backend.entity.AssignmentMarks;
import work.student_dashboard.backend.entity.Student;

public interface AssignmentMarksRepository extends JpaRepository<AssignmentMarks, Long> {

    boolean existsByStudentAndAssignment(Student s, Assignment a);

    @Query("SELECT SUM(a.marks) FROM AssignmentMarks a WHERE a.assignment.semester = ?1 AND a.assignment.subject.id = ?2 AND a.student.id = ?3")
    Integer getStudentGradeBySemesterAndSubject(int semester, long subjectId, long studentId);
}
