package com.spring.graphexample.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.graphexample.exception.ApiErrorCode;
import com.spring.graphexample.exception.ApiErrorHandler;
import com.spring.graphexample.mapper.MapperImpl;
import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.CandidateSuccessResp;
import com.spring.graphexample.model.JobApplication;
import com.spring.graphexample.model.JobSuccessResp;
import com.spring.graphexample.model.JobVacancy;
import com.spring.graphexample.utils.ModelFieldsValidation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("v1")
public class GraphProjectController {

	@Autowired
	private ModelFieldsValidation validation;

	@Autowired
	private ApiErrorHandler error;
	
	@Autowired
	private MapperImpl dbMapperImpl;
	
	@PostMapping(value = {"/candidate"}, 
				produces = "application/json")
	ResponseEntity<Object> insertCandidate(@RequestBody Candidate candidate, HttpServletRequest request) {
		if (!validation.candidateFieldsVerify(candidate)) {
			return error.handleApiError(ApiErrorCode.VALIDATION_ERROR);
		}
		
		Candidate candidateData = null;
		try {
			dbMapperImpl.insertCandidateData(candidate);
//			candidateData = dbMapperImpl.selectCandidateData(candidateInsertId);
			
		} catch (Exception ex) {
			return error.handleApiErrorException(ex);
		}
		return ResponseEntity.ok().body(new CandidateSuccessResp().candidateSuccess(candidateData));
	}

	@PostMapping(value = {"/vacancy"}, 
				produces = "application/json")
	ResponseEntity<Object> insertJobVacancies(@RequestBody JobVacancy jobVacancy, HttpServletRequest request) {
		if (!validation.jobVacancyFieldsVerify(jobVacancy)) {
			return error.handleApiError(ApiErrorCode.VALIDATION_ERROR);
		}
		
//		try {
//			dbMapperImpl.insertJobVacancyData(jobVacancy);
//		} catch (Exception ex) {
//			log.error("Error:", ex);
//			return error.handleApiErrorException(ex);
//		}
		
		return ResponseEntity.ok().body(new JobSuccessResp().jobSuccess(jobVacancy));
	}

	@PostMapping(value = {"/application"}, 
				produces = "application/json")
	ResponseEntity<Object> insertJobApplication(@RequestBody JobApplication jobApplication, HttpServletRequest request) {
		if (!validation.jobApplicationFieldsVerify(jobApplication)) {
			return error.handleApiError(ApiErrorCode.VALIDATION_ERROR);
		}

		return ResponseEntity.ok("Ok");
	}
	
}
