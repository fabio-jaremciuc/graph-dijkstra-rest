package com.spring.graphexample.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class JobVacancyTest {

	@Test
	final void test() {
	
		JobVacancy jobVacancy = new JobVacancy(1, "jobCompany", "jobTitle", "jobDescription", "jobLocation", 1);
		assertEquals(1, jobVacancy.getJobCompanyId());
		assertEquals("jobCompany", jobVacancy.getJobCompany());
		assertEquals("jobTitle", jobVacancy.getJobTitle());
		assertEquals("jobDescription", jobVacancy.getJobDescription());
		assertEquals("jobLocation", jobVacancy.getJobLocation());
		assertEquals(1, jobVacancy.getJobLevel());
		assertNotNull(jobVacancy);
	}

}
