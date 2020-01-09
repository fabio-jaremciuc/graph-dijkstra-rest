package com.spring.graphexample.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.JobVacancy;

@Mapper
public interface GraphProjectMapper {
	
//	@Options(useGeneratedKeys=true, keyProperty="candidateId", keyColumn="CANDIDATE_ID")
	
	//https://stackoverflow.com/questions/14827783/auto-increment-and-last-insert-id
	SELECT max(employeeid) FROM Employee;
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
	public int insertCandidateData(Candidate candidate);

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
	
//	@Select({
//		"INSERT INTO COMPANY(JOB_COMPANY, JOB_TITLE, JOB_DESCRIPTION, JOB_LOCATION, JOB_LEVEL)",
//		"VALUES("
//		+ "#{jobCompany},"
//		+ "#{jobTitle}, "
//		+ "#{jobDescription}, "
//		+ "#{jobLocation},"
//		+ "#{jobLevel});"
//	})
//	public JobVacancy insertJobVacancyData(JobVacancy jobVacancy);
//
//	@Select({
//		"SELECT * FROM CANDIDATE WHERE CANDIDATE_ID = #{jobVacancyId};"
//	})
//	public JobVacancy selectJobVacancyData(int jobVacancyId);
}
