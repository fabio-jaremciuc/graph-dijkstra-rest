package com.spring.graphexample.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.JobVacancy;

@Component
public class MapperImpl implements GraphProjectMapper {

    @Autowired
    private GraphProjectMapper graphMapper;
	
	public Candidate insertCandidateData(Candidate candidate) {
		return graphMapper.insertCandidateData(candidate);
	}

	public JobVacancy insertJobVacancyData(JobVacancy jobVacancy) {
		return graphMapper.insertJobVacancyData(jobVacancy);
	}

	public Candidate selectCandidate(int candidateId) {
		return graphMapper.selectCandidate(candidateId);
	}

	public JobVacancy selectJobVacancyData(int jobVacancyId) {
		return graphMapper.selectJobVacancyData(jobVacancyId);
	}

}
