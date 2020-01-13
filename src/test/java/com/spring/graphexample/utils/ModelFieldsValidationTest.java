package com.spring.graphexample.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.JobApplication;
import com.spring.graphexample.model.JobVacancy;

class ModelFieldsValidationTest {


	@Test
	final void candidateValidationTest() {
		ModelFieldsValidation modelFieldsValidation = new ModelFieldsValidation();
		Candidate candidate = new Candidate();
		List<String> paramsTest = modelFieldsValidation.candidateFieldsVerify(candidate);
		assertEquals("candidateName", paramsTest.stream()
												.filter(h -> "candidateName".equals(h))
												.collect(Collectors.toList()).get(0));
		assertEquals("candidateOccupation", paramsTest.stream()
														.filter(h -> "candidateOccupation".equals(h))
														.collect(Collectors.toList()).get(0));
		assertEquals("candidateLocation", paramsTest.stream()
														.filter(h -> "candidateLocation".equals(h))
														.collect(Collectors.toList()).get(0));
		assertEquals("candidateLevel", paramsTest.stream()
														.filter(h -> "candidateLevel".equals(h))
														.collect(Collectors.toList()).get(0));
		assertEquals("candidateAppPosition", paramsTest.stream()
														.filter(h -> "candidateAppPosition".equals(h))
														.collect(Collectors.toList()).get(0));
		
	}

	@Test
	final void vacanciesValidationTest() {
		ModelFieldsValidation modelFieldsValidation = new ModelFieldsValidation();
		JobVacancy jobVacancy = new JobVacancy();
		List<String> paramsTest = modelFieldsValidation.jobVacancyFieldsVerify(jobVacancy);
		
		assertEquals("jobCompany", paramsTest.stream()
													.filter(h -> "jobCompany".equals(h))
													.collect(Collectors.toList()).get(0));
		assertEquals("jobTitle", paramsTest.stream()
													.filter(h -> "jobTitle".equals(h))
													.collect(Collectors.toList()).get(0));
		assertEquals("jobDescription", paramsTest.stream()
													.filter(h -> "jobDescription".equals(h))
													.collect(Collectors.toList()).get(0));
		assertEquals("jobLocation", paramsTest.stream()
													.filter(h -> "jobLocation".equals(h))
													.collect(Collectors.toList()).get(0));
		assertEquals("jobLevel", paramsTest.stream()
													.filter(h -> "jobLevel".equals(h))
													.collect(Collectors.toList()).get(0));
	}

	@Test
	final void jobApplicationFieldsVerifyTest() {
		ModelFieldsValidation modelFieldsValidation = new ModelFieldsValidation();
		JobApplication candidature = new JobApplication();
		List<String> paramsTest = modelFieldsValidation.jobApplicationFieldsVerify(candidature);
		
		assertEquals("idCandidate", paramsTest.stream()
											.filter(h -> "idCandidate".equals(h))
											.collect(Collectors.toList()).get(0));
		assertEquals("idCandidate", paramsTest.stream()
											.filter(h -> "idCandidate".equals(h))
											.collect(Collectors.toList()).get(0));
	
	}

}
