package work.student_dashboard.backend.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import work.student_dashboard.backend.entity.Subject;


public interface SubjectRepository extends JpaRepository<Subject, Long> {
	Boolean existsBySubjectCode(String subjectCode);
}
