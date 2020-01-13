package com.spring.graphexample.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("graph/v1")
@Api(tags = { "Graph Dijkstra REST API"}, description = " ")
public class GraphProjectController implements GraphProject {

	@Autowired
	private ModelFieldsValidation validation;

	@Autowired
	private ApiErrorHandler error;
	
	@Autowired
	private MapperImpl dbMapperImpl;

	@Autowired
	private GraphService graphService;
	
	public ResponseEntity<Object> insertCandidate(@RequestBody Candidate candidate, HttpServletRequest request) {
		List<String> candiateMissingParams = validation.candidateFieldsVerify(candidate);
		if (!candiateMissingParams.isEmpty()) {
			return error.handleApiParamError(candiateMissingParams);
		}
		
		Candidate candidateData = null;
		try {
			dbMapperImpl.insertCandidateData(candidate);
			candidateData = dbMapperImpl.selectCandidateData(dbMapperImpl.getCandidateDataId());
		} catch (Exception ex) {
			return error.handleSQLErrorException(ex);
		}
		log.info("New candidate inserted: {}", candidateData);
		return ResponseEntity.ok().body(new CandidateSuccessResp().candidateSuccess(candidateData));
	}

	public ResponseEntity<Object> insertJobVacancies(@RequestBody JobVacancy jobVacancy, HttpServletRequest request) {
		List<String> vacanciesMissingParams =  validation.jobVacancyFieldsVerify(jobVacancy);
		if (!vacanciesMissingParams.isEmpty()) {
			return error.handleApiParamError(vacanciesMissingParams);
		}
		
		JobVacancy jobVacancyData = null;
		try {
			dbMapperImpl.insertJobVacancyData(jobVacancy);
			jobVacancyData = dbMapperImpl.selectJobVacancyData(dbMapperImpl.getJobDataId());
		} catch (Exception ex) {
			return error.handleSQLErrorException(ex);
		}
		log.info("New job vacancy posted: {}", jobVacancyData);
		return ResponseEntity.ok().body(new JobSuccessResp().jobSuccess(jobVacancyData));
	}

	public ResponseEntity<Object> insertJobApplication(@RequestBody JobApplication jobApplication, HttpServletRequest request) {
		GraphCalc graphCalc = new GraphCalc();
		Candidate candidateData = null;
		JobVacancy jobVacancyData = null;
		List<String> candidatureMissingParams = validation.jobApplicationFieldsVerify(jobApplication); 
		if (!candidatureMissingParams.isEmpty()) {
			return error.handleApiParamError(candidatureMissingParams);
		}
		
		try {
			candidateData = dbMapperImpl.selectCandidateData(jobApplication.getIdCandidate());
			jobVacancyData = dbMapperImpl.selectJobVacancyData(jobApplication.getIdVacancy());
		} catch (Exception ex) {
			return error.handleSQLErrorException(ex);
		}
		
		if (candidateData == null || jobVacancyData == null) {
			return ResponseEntity.status(500).body(new ErrorDetail("Error", 500, "Bad Request - "
					+ "database has no data regarding this job application."));
		}
		
		Double shortestPath = graphCalc.getShortestPath(new NodeWeighted(candidateData.getCandidateLocation()), 
				new NodeWeighted(jobVacancyData.getJobLocation()));

		if (shortestPath == 0.0) {
			return ResponseEntity.status(500).body(new ErrorDetail("Error", 500, "Bad Request - Inserted nodes "
					+ "have no connection or are not registered in the system"));
		}
		
		int experienceCandidateLevel = graphService.calcExpirenceLevel(candidateData.getCandidateLevel(), 
				jobVacancyData.getJobLevel());
		int candidateFinalScore = graphService.calcScoreCandidate(experienceCandidateLevel, shortestPath);
		CandidateRanked candidateRanked = setCandidateRankedData(candidateData, candidateFinalScore);
		
		try {
			dbMapperImpl.insertRankingData(candidateRanked);
		} catch (Exception ex) {
			return error.handleSQLErrorException(ex);
		}
		log.info("Candidate ranked: {}", candidateRanked);
		return ResponseEntity.ok().body(candidateRanked);
	}

	public ResponseEntity<Object> getApplicationRanking(HttpServletRequest request) {
		List<CandidateRanked> candidateRanked = null;
		try {
			candidateRanked = dbMapperImpl.selectRankingData();
		} catch (Exception ex) {
			return error.handleSQLErrorException(ex);
		}
		log.info("Final ranking: {}", candidateRanked);
		return ResponseEntity.ok().body(candidateRanked);
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
