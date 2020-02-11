package work.student_dashboard.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.student_dashboard.backend.entity.User;
import work.student_dashboard.backend.services.AuthService;
import work.student_dashboard.backend.services.UserService;

//import com.pavithraprbd.springboot.entity.Employee;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthService authService;
	
	@Value("${app.baseUrl}")
	String baseUrl;
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> findUserDetails(@PathVariable Long id) {
		return userService.getUserDetails(id);
	}	
	
	@GetMapping("/me")
	public ResponseEntity<?> findMyDetails(@RequestHeader(name = "Authorization") String token) {
		User u = authService.decodeJWTToken(token);
		u.setProPic(baseUrl+u.getProPic());
		return ResponseEntity.ok(u);
	}	
}
