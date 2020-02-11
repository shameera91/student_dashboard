package work.student_dashboard.backend.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import work.student_dashboard.backend.entity.Student;
import work.student_dashboard.backend.entity.User;


public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Boolean existsByStudentId(String studentId);
	Optional<Student> findByStudentId(String studentId);
	List<Student> findByIdNotIn(List<Long> id);
	
}
