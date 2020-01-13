package com.spring.graphexample.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class JobApplicationTest {

	@Test
	final void test() {
		JobApplication jobApplication = new JobApplication(1, 1);

		assertEquals(1, jobApplication.getIdCandidate());
		assertEquals(1, jobApplication.getIdVacancy());
		assertNotNull(jobApplication);
	}

}
