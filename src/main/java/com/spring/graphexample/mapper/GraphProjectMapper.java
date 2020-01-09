package com.spring.graphexample.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.JobVacancy;

@Mapper
public interface GraphProjectMapper {

	@Insert({
		"INSERT INTO CANDIDATE(CANDIDATE_NAME, CANDIDATE_OCCUPATION, CANDIDATE_LOCATION, "
		+ "CANDIDATE_LEVEL, CANDIDATE_APP_POSITION)",
		"VALUES("
		+ "#{candidateName},"
		+ "#{candidateOccupation}, "
		+ "#{candidateLocation}, "
		+ "#{candidateLevel},"
		+ "#{candidateAppPosition});"
	})
	@Options(useGeneratedKeys=true, keyProperty="candidateId", keyColumn="CANDIDATE_ID")
	public Integer insertCandidateData(Candidate candidate);

	@Select({"<script> ",
		"SELECT * FROM CANDIDATE;",
		"</script>"
	})
	public Candidate selectCandidateData();
	
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
		"SELECT * FROM CANDIDATE WHERE CANDIDATE_ID = #{jobVacancyId};"
	})
	public JobVacancy selectJobVacancyData(int jobVacancyId);
}
