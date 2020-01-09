package com.spring.graphexample.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphexample.model.Candidate;

@Component
public class MapperImpl implements GraphProjectMapper {

    @Autowired
    private GraphProjectMapper graphMapper;
	
	public int insertCandidateData(Candidate candidate) {
		return graphMapper.insertCandidateData(candidate);
	}

	public Candidate selectCandidateData(Integer candidateId) {
		return graphMapper.selectCandidateData(candidateId);
	}

//	public JobVacancy insertJobVacancyData(JobVacancy jobVacancy) {
//		return graphMapper.insertJobVacancyData(jobVacancy);
//	}
//
//	public JobVacancy selectJobVacancyData(int jobVacancyId) {
//		return graphMapper.selectJobVacancyData(jobVacancyId);
//	}
}
