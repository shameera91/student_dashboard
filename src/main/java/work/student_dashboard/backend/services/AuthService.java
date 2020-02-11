package work.student_dashboard.backend.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import work.student_dashboard.backend.entity.RoleName;
import work.student_dashboard.backend.entity.User;
import work.student_dashboard.backend.payloads.ApiResponse;
import work.student_dashboard.backend.payloads.JwtResponse;
import work.student_dashboard.backend.payloads.LoginRequest;
import work.student_dashboard.backend.payloads.SignUpRequest;
import work.student_dashboard.backend.repository.UserRepository;
import work.student_dashboard.backend.security.JwtTokenProvider;

@Service
public class AuthService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider tokenProvider;

	public ResponseEntity<?> signIn(LoginRequest loginRequest) throws Exception {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication);
	
		User user = userRepository.findByEmail(loginRequest.getUsername()).get();
		JwtResponse response = new JwtResponse(jwt);
		response.setUserPrivilage(user.getRole().toString());
		
		return ResponseEntity.ok(response);
	}

	@Transactional
	public ResponseEntity<?> signUp(SignUpRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "User alredy exsist in the system."),
					HttpStatus.BAD_REQUEST);
		}
		// hash or encode the password;
		String password = passwordEncoder.encode(signUpRequest.getPassword());
		// Creating user's account
		User user = new User(signUpRequest.getFullName(), signUpRequest.getEmail(),
				password, RoleName.ROLE_PROFESSOR);

		userRepository.save(user);
		
		return (ResponseEntity<?>) ResponseEntity.ok(new ApiResponse(true, "User created successfully."));
	}

	public User decodeJWTToken(String token) {
		// split the JWT token and extract the payload part(in base64 format) which is
		// in the middle of the JWT token
		String base64TokenPayload = token.split("\\.")[1];

		// decode base64 JWY token payload
		String tokenPayload = new String(Base64.getDecoder().decode(base64TokenPayload));
		String fullPayload = tokenPayload.substring(1, tokenPayload.length() - 1);
		String sub = fullPayload.split(",")[0];
		String subVal = sub.split(":")[1];
		String realSubVal = subVal.substring(1, subVal.length() - 1);

		// get the relevant user according to the user id extracted from JWT token
		User user = userRepository.findById(Long.parseLong(realSubVal)).get();

		return user;
	}
}
