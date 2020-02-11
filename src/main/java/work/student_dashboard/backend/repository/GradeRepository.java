package work.student_dashboard.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import work.student_dashboard.backend.entity.Grade;
import work.student_dashboard.backend.entity.Student;

public interface GradeRepository extends JpaRepository<Grade, Long> {

	boolean existsByYearAndSemesterAndStudent(String year, int semester,Student s);
	List<Grade> findByYearAndSemesterAndStudent(String year, int semester,Student s);
	
}
