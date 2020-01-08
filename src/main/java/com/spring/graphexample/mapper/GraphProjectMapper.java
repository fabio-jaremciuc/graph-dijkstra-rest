package com.spring.graphexample.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.JobVacancy;

@Mapper
public interface GraphProjectMapper {

	@Select({
		"INSERT INTO CANDIDATE(CANDIDATE_NAME, CANDIDATE_OCCUPATION, CANDIDATE_LOCATION, "
		+ "CANDIDATE_LEVEL, CANDIDATE_APP_POSITION)",
		"VALUES("
		+ "#{candidateName},"
		+ "#{candidateOccupation}, "
		+ "#{candidateLocation}, "
		+ "#{candidateLevel},"
		+ "#{candidateAppPosition});"
	})
	public Candidate insertCandidateData(Candidate candidate);
	
	@Select({
		"INSERT INTO COMPANY(JOB_COMPANY, JOB_TITLE, JOB_DESCRIPTION, JOB_LOCATION, JOB_LEVEL)",
		"VALUES("
		+ "#{jobCompany},"
		+ "#{jobTitle}, "
		+ "#{jobDescription}, "
		+ "#{jobLocation},"
		+ "#{jobLevel});"
	})
	public JobVacancy insertJobVacancyData(JobVacancy jobVacancy);
	
	@Select({
		"SELECT * FROM CANDIDATE WHERE CANDIDATE_ID = #{candidateId};"
	})
	public Candidate selectCandidate(int candidateId);

	@Select({
		"SELECT * FROM CANDIDATE WHERE CANDIDATE_ID = #{jobVacancyId};"
	})
	public JobVacancy selectJobVacancyData(int jobVacancyId);
}
