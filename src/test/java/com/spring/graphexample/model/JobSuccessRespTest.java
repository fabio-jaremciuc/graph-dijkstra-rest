package com.spring.graphexample.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class JobSuccessRespTest {

	@Test
	final void test() {
		JobVacancy jobVacancy = new JobVacancy(1, "jobCompany", "jobTitle", "jobDescription", "jobLocation", 2);
		JobSuccessResp jobSuccessResp = new JobSuccessResp("OK", "OK", jobVacancy);
		assertEquals("OK", jobSuccessResp.getStatus());
		assertEquals("OK", jobSuccessResp.getMessage());
		assertEquals(2, jobSuccessResp.getData().getJobLevel());
		assertNotNull(jobSuccessResp);
	}

}
