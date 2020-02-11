package work.student_dashboard.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.student_dashboard.backend.entity.Assignment;
import work.student_dashboard.backend.entity.Subject;

import java.util.List;

/**
 * Created By Shameera.A on 2/9/2020
 */
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    Boolean existsByAssignmentCode(String assignmentCode);

    List<Assignment> getAllBySemester(int semester);

    List<Assignment> getAllBySemesterAndSubject(int semester, Subject subject);
}
