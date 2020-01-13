package com.spring.graphexample.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.JobApplication;
import com.spring.graphexample.model.JobVacancy;

@Component
public class ModelFieldsValidation {

	public List<String> candidateFieldsVerify(Candidate candidate) {
		List<String> emptyParams = new ArrayList<>();
		if (StringUtils.isEmpty(candidate.getCandidateName())){
			emptyParams.add("candidateName");
		}
		if (StringUtils.isEmpty(candidate.getCandidateOccupation())) {
			emptyParams.add("candidateOccupation");
		}
		if (StringUtils.isEmpty(candidate.getCandidateLocation())) {
			emptyParams.add("candidateLocation");
		}
		if (candidate.getCandidateLevel() == 0) {
			emptyParams.add("candidateLevel");
		}
		if (StringUtils.isEmpty(candidate.getCandidateAppPosition())) {
			emptyParams.add("candidateAppPosition");
		}
		return emptyParams;
	}

	public List<String> jobVacancyFieldsVerify(JobVacancy jobVacancy) {
		List<String> emptyParams = new ArrayList<>();
		
		if (StringUtils.isEmpty(jobVacancy.getJobCompany())) {
			emptyParams.add("jobCompany");
		}
		if (StringUtils.isEmpty(jobVacancy.getJobTitle())) {
			emptyParams.add("jobTitle");
		}
		if (StringUtils.isEmpty(jobVacancy.getJobDescription())) {
			emptyParams.add("jobDescription");
		}
		if (StringUtils.isEmpty(jobVacancy.getJobLocation())) {
			emptyParams.add("jobLocation");
		}
		if (jobVacancy.getJobLevel() == 0) {
			emptyParams.add("jobLevel");
		}
		return emptyParams;
	}

	public List<String> jobApplicationFieldsVerify(JobApplication jobApplication) {
		List<String> emptyParams = new ArrayList<>();
		if (jobApplication.getIdCandidate() == 0) {
			emptyParams.add("idCandidate");
		}
		if (jobApplication.getIdVacancy() == 0) {
			emptyParams.add("idVacancy");
		}
		return emptyParams;
	}
}