package work.student_dashboard.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import work.student_dashboard.backend.entity.RoleName;
import work.student_dashboard.backend.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
	Boolean existsByEmail(String email);
	Optional<User> findByEmail(String email);
	Optional<User> findById(long id);
	List<User> findByRole(RoleName roleName);

}
