package work.student_dashboard.backend.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.student_dashboard.backend.entity.User;
import work.student_dashboard.backend.payloads.LoginRequest;
import work.student_dashboard.backend.payloads.SignUpRequest;
import work.student_dashboard.backend.services.AuthService;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
		// Generate the token and send it
		return authService.signIn(loginRequest);
	}

	
	@PostMapping("/sign-up")
	public ResponseEntity<?> signUpUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		return authService.signUp(signUpRequest);
	}

}
