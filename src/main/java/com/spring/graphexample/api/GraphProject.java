package com.spring.graphexample.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.graphexample.exception.ErrorDetail;
import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.CandidateRanked;
import com.spring.graphexample.model.JobApplication;
import com.spring.graphexample.model.JobVacancy;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface GraphProject {

	@ApiOperation(value = "API for entering new candidates", 
			nickname = "insertCandidate", 
			notes = "API for entering new candidates", 
			response = ResponseEntity.class, tags = {"Candidate"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Accepted", response = Candidate.class),
			@ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
			@ApiResponse(code = 403, message = "Forbidden", response = ErrorDetail.class),
			@ApiResponse(code = 429, message = "Too Many Requests", response = ErrorDetail.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
			@ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
	@PostMapping(value = "/candidate", produces = { "application/json" })
	ResponseEntity<Object> insertCandidate(@RequestBody Candidate candidate, HttpServletRequest request);

	@ApiOperation(value = "API for entering new vacancies", 
			nickname = "insertJobVacancies", 
			notes = "API for entering new vacancies", 
			response = ResponseEntity.class, tags = {"Vacancy"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Accepted", response = JobVacancy.class),
			@ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
			@ApiResponse(code = 403, message = "Forbidden", response = ErrorDetail.class),
			@ApiResponse(code = 429, message = "Too Many Requests", response = ErrorDetail.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
			@ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
	@PostMapping(value = "/vacancy", produces = { "application/json" })
	ResponseEntity<Object> insertJobVacancies(@RequestBody JobVacancy jobVacancy, HttpServletRequest request);

	@ApiOperation(value = "API for entering candidatures", 
			nickname = "insertJobApplication", 
			notes = "API for entering candidatures", 
			response = ResponseEntity.class, tags = {"Application"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Accepted", response = CandidateRanked.class),
			@ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
			@ApiResponse(code = 403, message = "Forbidden", response = ErrorDetail.class),
			@ApiResponse(code = 429, message = "Too Many Requests", response = ErrorDetail.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
			@ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
	@PostMapping(value = "/application", produces = { "application/json" })
	ResponseEntity<Object> insertJobApplication(@RequestBody JobApplication jobApplication, HttpServletRequest request);

	@ApiOperation(value = "API to get the ranking", 
			nickname = "getApplicationRanking", 
			notes = "API to get the ranking", 
			response = ResponseEntity.class, tags = {"Ranking"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Accepted", response = CandidateRanked.class),
			@ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
			@ApiResponse(code = 403, message = "Forbidden", response = ErrorDetail.class),
			@ApiResponse(code = 429, message = "Too Many Requests", response = ErrorDetail.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
			@ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
	@GetMapping(value = "/application/ranking", produces = { "application/json" })
	ResponseEntity<Object> getApplicationRanking(HttpServletRequest request);
	
}
