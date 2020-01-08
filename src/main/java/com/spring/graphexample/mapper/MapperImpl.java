package com.spring.graphexample.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.graphexample.model.Candidate;

@Component
public class MapperImpl implements GraphProjectMapper {

    @Autowired
    private GraphProjectMapper graphMapper;
	
	public Candidate insertCandidateData(Candidate candidate) {
		return graphMapper.insertCandidateData(candidate);
	}

}
