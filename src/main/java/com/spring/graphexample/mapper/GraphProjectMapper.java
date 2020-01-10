package com.spring.graphexample.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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
	public void insertCandidateData(Candidate candidate);

	@Select({"SELECT MAX(CANDIDATE_ID) FROM CANDIDATE;"})
	public int getCandidateDataId();
	
	@Select({"SELECT * FROM CANDIDATE WHERE CANDIDATE_ID = #{candidateId};"})
	@Results(value = {
			@Result(property = "candidateId", column = "CANDIDATE_ID"),
			@Result(property = "candidateName", column = "CANDIDATE_NAME"),
			@Result(property = "candidateOccupation", column = "CANDIDATE_OCCUPATION"),
			@Result(property = "candidateLocation", column = "CANDIDATE_LOCATION"),
			@Result(property = "candidateLevel", column = "CANDIDATE_LEVEL"),
			@Result(property = "candidateAppPosition", column = "CANDIDATE_APP_POSITION")
	})
	public Candidate selectCandidateData(@Param("candidateId") Integer candidateId);
	
	@Insert({
		"INSERT INTO JOB(JOB_COMPANY, JOB_TITLE, JOB_DESCRIPTION, JOB_LOCATION, JOB_LEVEL)",
		"VALUES("
		+ "#{jobCompany},"
		+ "#{jobTitle}, "
		+ "#{jobDescription}, "
		+ "#{jobLocation},"
		+ "#{jobLevel});"
	})
	public void insertJobVacancyData(JobVacancy jobVacancy);

	@Select({"SELECT MAX(JOB_ID) FROM JOB;"})
	public int getJobDataId();
	
	@Select({
		"SELECT * FROM JOB WHERE JOB_ID = #{jobCompanyId};"
	})
	@Results(value = {
			@Result(property = "jobCompanyId", column = "JOB_ID"),
			@Result(property = "jobCompany", column = "JOB_COMPANY"),
			@Result(property = "jobTitle", column = "JOB_TITLE"),
			@Result(property = "jobDescription", column = "JOB_DESCRIPTION"),
			@Result(property = "jobLocation", column = "JOB_LOCATION"),
			@Result(property = "jobLevel", column = "JOB_LEVEL")
	})
	public JobVacancy selectJobVacancyData(@Param("jobCompanyId") Integer jobCompanyId);
}
