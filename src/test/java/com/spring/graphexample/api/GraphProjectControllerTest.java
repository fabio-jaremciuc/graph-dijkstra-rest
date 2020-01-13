package com.spring.graphexample.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.JobApplication;
import com.spring.graphexample.model.JobVacancy;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(value = "classpath:application-test.properties")
class GraphProjectControllerTest {
	
	@Autowired
	private GraphProject graph;

	private static MockHttpServletRequest request = new MockHttpServletRequest();
	
	@Before
	public void loadRequest() {
		request.setServerName("www.example.com");
		request.setRequestURI("/test");
		request.setMethod("Post");	
	}
	
	Candidate candidate = new Candidate(0, "candidateNameTest", "candidateOccupationTest", "A", 
			5, "candidateAppPosition");
	JobVacancy jobVacancy = new JobVacancy(0, "jobCompanyTest", "jobTitleTest", "jobDescriptionTest", "G", 5);
	JobApplication jobApplication = new JobApplication(1, 1);
	
	@Test
	final void insertCandidateSuccessTest() {
		ResponseEntity<Object> response = graph.insertCandidate(candidate, request);
		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	final void insertJobVacanciesTest() {
		ResponseEntity<Object> response = graph.insertJobVacancies(jobVacancy, request);
		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	final void insertJobApplicationTest() {
		graph.insertCandidate(candidate, request);
		graph.insertJobVacancies(jobVacancy, request);
		ResponseEntity<Object> response = graph.insertJobApplication(jobApplication, request);
		assertEquals(200, response.getStatusCodeValue());
	}

}
