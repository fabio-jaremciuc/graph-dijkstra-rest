package com.spring.graphexample.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spring.graphexample.model.Candidate;

@Mapper
public interface GraphProjectMapper {

	@Select({
		"<script> ",
		"INSERT INTO CANDIDATE(CANDIDATE_NAME, CANDIDATE_OCCUPATION, CANDIDATE_LOCATION, "
		+ "CANDIDATE_LEVEL, CANDIDATE_APP_POSITION)",
		"VALUES(("
		+ "candidate.candidateName, "
		+ "candidate.candidateOccupation, "
		+ "candidate.candidateLocation, "
		+ "candidate.candidateLevel,"
		+ "candidate.candidateAppPosition));",
		"</script>"
	})
	public Candidate insertCandidateData(@Param("candidate") Candidate candidate);
	
	
	
}
