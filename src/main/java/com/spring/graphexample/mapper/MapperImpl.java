package com.spring.graphexample.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.CandidateRanked;
import com.spring.graphexample.model.JobVacancy;

@Component
public class MapperImpl implements GraphProjectMapper {

    @Autowired
    private GraphProjectMapper graphMapper;
	
	public void insertCandidateData(Candidate candidate) {
		graphMapper.insertCandidateData(candidate);
	}

	public int getCandidateDataId() {
		return graphMapper.getCandidateDataId();
	}
	
	public Candidate selectCandidateData(Integer candidateId) {
		return graphMapper.selectCandidateData(candidateId);
	}

	public void insertJobVacancyData(JobVacancy jobVacancy) {
		graphMapper.insertJobVacancyData(jobVacancy);
	}
	
	public int getJobDataId() {
		return graphMapper.getJobDataId();
	}

	public JobVacancy selectJobVacancyData(Integer jobVacancyId) {
		return graphMapper.selectJobVacancyData(jobVacancyId);
	}

	public void insertRankingData(CandidateRanked candidateRanked) {
		graphMapper.insertRankingData(candidateRanked);
	}


}
