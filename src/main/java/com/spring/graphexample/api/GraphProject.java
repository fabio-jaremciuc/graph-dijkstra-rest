package com.spring.graphexample.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.graphexample.exception.ErrorDetail;
import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.CandidateRanked;
import com.spring.graphexample.model.CandidateSuccessResp;
import com.spring.graphexample.model.CandidatesRanking;
import com.spring.graphexample.model.JobApplication;
import com.spring.graphexample.model.JobSuccessResp;
import com.spring.graphexample.model.JobVacancy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "graph-dijkstra-rest", 
	description = "Dijkstra Algorithm for Vacancy Matching")
public interface GraphProject {

	@ApiOperation(value = "API for entering new candidates", 
			nickname = "insertCandidate", 
			notes = "API for entering new candidates", 
			response = ResponseEntity.class, tags = {"candidate"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Accepted", response = CandidateSuccessResp.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
			@ApiResponse(code = 403, message = "Forbidden", response = ErrorDetail.class),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
			@ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
	@PostMapping(value = "/candidate", produces = { "application/json" })
	ResponseEntity<Object> insertCandidate(@RequestBody Candidate candidate, HttpServletRequest request);

	@ApiOperation(value = "API for entering new job vacancies", 
			nickname = "insertJobVacancies", 
			notes = "API for entering new job vacancies", 
			response = ResponseEntity.class, tags = {"vacancy"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Accepted", response = JobSuccessResp.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
			@ApiResponse(code = 403, message = "Forbidden", response = ErrorDetail.class),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
			@ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
	@PostMapping(value = "/vacancy", produces = { "application/json" })
	ResponseEntity<Object> insertJobVacancies(@RequestBody JobVacancy jobVacancy, HttpServletRequest request);

	@ApiOperation(value = "API for entering candidatures", 
			nickname = "insertJobApplication", 
			notes = "API for entering candidatures", 
			response = ResponseEntity.class, tags = {"application"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Accepted", response = CandidateRanked.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
			@ApiResponse(code = 403, message = "Forbidden", response = ErrorDetail.class),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
			@ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
	@PostMapping(value = "/application", produces = { "application/json" })
	ResponseEntity<Object> insertJobApplication(@RequestBody JobApplication jobApplication, HttpServletRequest request);

	@ApiOperation(value = "API to get the ranking", 
			nickname = "getApplicationRanking", 
			notes = "API to get the ranking", 
			response = ResponseEntity.class, tags = {"ranking"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Accepted", response = CandidatesRanking.class),
			@ApiResponse(code = 400, message = "Bad Request", response = ErrorDetail.class),
			@ApiResponse(code = 403, message = "Forbidden", response = ErrorDetail.class),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
			@ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
			@ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
	@GetMapping(value = "/application/ranking", produces = { "application/json" })
	ResponseEntity<Object> getApplicationRanking(HttpServletRequest request);
	
}
