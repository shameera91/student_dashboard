package work.student_dashboard.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import work.student_dashboard.backend.entity.RoleName;
import work.student_dashboard.backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	@Transactional
	public ResponseEntity<?> getUserDetails(Long id) {
		return ResponseEntity.ok(userRepository.findById(id));
	}
	
	
}
