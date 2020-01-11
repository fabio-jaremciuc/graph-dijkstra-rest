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
import com.spring.graphexample.exception.ErrorDetail;
import com.spring.graphexample.graph.GraphCalc;
import com.spring.graphexample.graph.NodeWeighted;
import com.spring.graphexample.mapper.MapperImpl;
import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.CandidateRanked;
import com.spring.graphexample.model.CandidateSuccessResp;
import com.spring.graphexample.model.JobApplication;
import com.spring.graphexample.model.JobSuccessResp;
import com.spring.graphexample.model.JobVacancy;
import com.spring.graphexample.service.GraphService;
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

	@Autowired
	private GraphService graphService;
	
	@PostMapping(value = {"/candidate"}, 
				produces = "application/json")
	ResponseEntity<Object> insertCandidate(@RequestBody Candidate candidate, HttpServletRequest request) {
		if (!validation.candidateFieldsVerify(candidate)) {
			return error.handleApiError(ApiErrorCode.VALIDATION_ERROR);
		}
		
		Candidate candidateData = null;
		try {
			dbMapperImpl.insertCandidateData(candidate);
			candidateData = dbMapperImpl.selectCandidateData(dbMapperImpl.getCandidateDataId());
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
		
		JobVacancy jobVacancyData = null;
		try {
			dbMapperImpl.insertJobVacancyData(jobVacancy);
			jobVacancyData = dbMapperImpl.selectJobVacancyData(dbMapperImpl.getJobDataId());
		} catch (Exception ex) {
			log.error("Error:", ex);
			return error.handleApiErrorException(ex);
		}
		
		return ResponseEntity.ok().body(new JobSuccessResp().jobSuccess(jobVacancyData));
	}

	@PostMapping(value = {"/application"}, 
				produces = "application/json")
	ResponseEntity<Object> insertJobApplication(@RequestBody JobApplication jobApplication, HttpServletRequest request) {
		GraphCalc graphCalc = new GraphCalc();
		Candidate candidateData = null;
		JobVacancy jobVacancyData = null;
		
		if (!validation.jobApplicationFieldsVerify(jobApplication)) {
			return error.handleApiError(ApiErrorCode.VALIDATION_ERROR);
		}
		
		try {
			candidateData = dbMapperImpl.selectCandidateData(jobApplication.getIdCandidate());
			jobVacancyData = dbMapperImpl.selectJobVacancyData(jobApplication.getIdVacancy());
		} catch (Exception ex) {
			return error.handleApiErrorException(ex);
		}
		
//		if (candidateData == null || jobVacancyData == null) {
//			return ResponseEntity.status(500).body(new ErrorDetail("Error", 500, "Bad Request - "
//					+ "database has no data regarding this job application."));
//		}
		
//		Double test = graphCalc.getShortestPath(new NodeWeighted(candidateData.getCandidateLocation()), 
//				new NodeWeighted(jobVacancyData.getJobLocation()));
		Double shortestPath = graphCalc.getShortestPath(new NodeWeighted("A"), 
				new NodeWeighted("G"));
		
		if (shortestPath == 0.0) {
			return ResponseEntity.status(500).body(new ErrorDetail("Error", 500, "Bad Request - Inserted nodes "
					+ "have no connection or are not registered in the system"));
		}
		
		int experienceCandidateLevel = graphService.calcExpirenceLevel(candidateData.getCandidateLevel(), 
				jobVacancyData.getJobLevel());
		int candidateFinalScore = graphService.calcScoreCandidate(experienceCandidateLevel, shortestPath);
		dbMapperImpl.insertRankingData(setCandidateRankedData(candidateData, candidateFinalScore));
		
		return ResponseEntity.ok("Ok");
	}

	private CandidateRanked setCandidateRankedData(Candidate candidateData, int candidateFinalScore) {
		CandidateRanked candidateRanked = new CandidateRanked();
		candidateRanked.setCandidateId(candidateData.getCandidateId());
		candidateRanked.setCandidateLevel(candidateData.getCandidateLevel());
		candidateRanked.setCandidateLocation(candidateData.getCandidateLocation());
		candidateRanked.setCandidateScore(candidateFinalScore);
		return candidateRanked;
	}
	
}
