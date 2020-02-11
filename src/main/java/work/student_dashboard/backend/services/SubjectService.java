package work.student_dashboard.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import work.student_dashboard.backend.entity.Subject;
import work.student_dashboard.backend.payloads.ApiResponse;
import work.student_dashboard.backend.repository.SubjectRepository;


@Service
public class SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	@Transactional
	public ResponseEntity<ApiResponse> createSubject(Subject subject) {
		
		if(subjectRepository.existsBySubjectCode(subject.getSubjectCode())) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "subject already exists in the system."),
					HttpStatus.BAD_REQUEST);
		}	
		subject.setId(0);
		subjectRepository.save(subject);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "subject saved in the system."),
				HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<?> getAllSubjects() {
		return ResponseEntity.ok(subjectRepository.findAll());
	}
	
}
