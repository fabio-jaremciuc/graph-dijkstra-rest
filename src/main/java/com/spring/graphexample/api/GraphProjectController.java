package com.spring.graphexample.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.graphexample.exception.ApiErrorCode;
import com.spring.graphexample.exception.ApiErrorHandler;
import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.JobApplication;
import com.spring.graphexample.model.JobVacancy;
import com.spring.graphexample.utils.ModelFieldsValidation;

@RestController
@RequestMapping("v1")
public class GraphProjectController {

	@Autowired
	private ModelFieldsValidation validation;

	@Autowired
	private ApiErrorHandler error;
	
	@GetMapping(value = {"/candidate"}, 
				produces = "application/json")
	ResponseEntity<Object> putCandidate(@RequestBody Candidate candidate, HttpServletRequest request) {
		if (!validation.candidateFieldsVerify(candidate)) {
			return error.handleApiError(ApiErrorCode.VALIDATION_ERROR);
		}
		
		return ResponseEntity.ok("Ok");
	}

	@GetMapping(value = {"/vacancy"}, 
				produces = "application/json")
	ResponseEntity<Object> putJobVacancies(@RequestBody JobVacancy jobVacancy, HttpServletRequest request) {
		if (!validation.jobVacancyFieldsVerify(jobVacancy)) {
			return error.handleApiError(ApiErrorCode.VALIDATION_ERROR);
		}
		
		return ResponseEntity.ok("Ok");
	}

	@GetMapping(value = {"/application"}, 
				produces = "application/json")
	ResponseEntity<Object> putJobApplication(@RequestBody JobApplication jobApplication, HttpServletRequest request) {
		if (!validation.jobApplicationFieldsVerify(jobApplication)) {
			return error.handleApiError(ApiErrorCode.VALIDATION_ERROR);
		}

		return ResponseEntity.ok("Ok");
	}
	
}
