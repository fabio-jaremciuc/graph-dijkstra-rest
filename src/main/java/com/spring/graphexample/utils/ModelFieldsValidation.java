package com.spring.graphexample.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.JobApplication;
import com.spring.graphexample.model.JobVacancy;

@Component
public class ModelFieldsValidation {

	public boolean candidateFieldsVerify(Candidate candidate) {
		if (StringUtils.isNotEmpty(candidate.getCandidateName()) &&
			StringUtils.isNotEmpty(candidate.getCandidateOccupation()) &&
			StringUtils.isNotEmpty(candidate.getCandidateLocation()) &&
			candidate.getCandidateLevel() != 0 &&
			StringUtils.isNotEmpty(candidate.getCandidateAppPosition())) {			
			return true;
		} else {
			return false;
		}
	}

	public boolean jobVacancyFieldsVerify(JobVacancy jobVacancy) {
		if (StringUtils.isNotEmpty(jobVacancy.getJobCompany()) &&
			StringUtils.isNotEmpty(jobVacancy.getJobTitle()) &&
			StringUtils.isNotEmpty(jobVacancy.getJobDescription()) &&
			StringUtils.isNotEmpty(jobVacancy.getJobLocation()) &&
			jobVacancy.getJobLevel() != 0) {			
			return true;
		} else {
			return false;
		}
	}

	public boolean jobApplicationFieldsVerify(JobApplication jobApplication) {
		if (jobApplication.getIdCandidate() != 0 && jobApplication.getIdVacancy() != 0) {			
			return true;
		} else {
			return false;
		}
	}
}
