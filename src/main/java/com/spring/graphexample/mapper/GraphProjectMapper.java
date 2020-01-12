package com.spring.graphexample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.spring.graphexample.model.Candidate;
import com.spring.graphexample.model.CandidateRanked;
import com.spring.graphexample.model.JobVacancy;

@Mapper
public interface GraphProjectMapper {
	
	@Insert({
		"INSERT INTO candidate(candidate_name, candidate_occupation, candidate_location, "
		+ "candidate_level, candidate_app_position)",
		"VALUES("
		+ "#{candidateName},"
		+ "#{candidateOccupation}, "
		+ "#{candidateLocation}, "
		+ "#{candidateLevel},"
		+ "#{candidateAppPosition});"
	})
	public void insertCandidateData(Candidate candidate);

	@Select({"SELECT MAX(candidate_id) FROM candidate;"})
	public int getCandidateDataId();
	
	@Select({"SELECT * FROM candidate WHERE candidate_id = #{candidateId};"})
	@Results(value = {
			@Result(property = "candidateId", column = "candidate_id"),
			@Result(property = "candidateName", column = "candidate_name"),
			@Result(property = "candidateOccupation", column = "candidate_occupation"),
			@Result(property = "candidateLocation", column = "candidate_location"),
			@Result(property = "candidateLevel", column = "candidate_level"),
			@Result(property = "candidateAppPosition", column = "candidate_app_position")
	})
	public Candidate selectCandidateData(@Param("candidateId") Integer candidateId);
	
	@Insert({
		"INSERT INTO job(job_company, job_title, job_description, job_location, job_level)",
		"VALUES("
		+ "#{jobCompany},"
		+ "#{jobTitle}, "
		+ "#{jobDescription}, "
		+ "#{jobLocation},"
		+ "#{jobLevel});"
	})
	public void insertJobVacancyData(JobVacancy jobVacancy);

	@Select({"SELECT MAX(job_id) FROM job;"})
	public int getJobDataId();
	
	@Select({
		"SELECT * FROM job WHERE job_id = #{jobCompanyId};"
	})
	@Results(value = {
			@Result(property = "jobCompanyId", column = "job_id"),
			@Result(property = "jobCompany", column = "job_company"),
			@Result(property = "jobTitle", column = "job_title"),
			@Result(property = "jobDescription", column = "job_description"),
			@Result(property = "jobLocation", column = "job_location"),
			@Result(property = "jobLevel", column = "job_level")
	})
	public JobVacancy selectJobVacancyData(@Param("jobCompanyId") Integer jobCompanyId);
	
	@Insert({
		"INSERT INTO ranking(candidate_id, raking_location, raking_level, score)",
		"VALUES("
		+ "#{candidateId},"
		+ "#{candidateLocation}, "
		+ "#{candidateLevel}, "
		+ "#{candidateScore});"
	})
	public void insertRankingData(CandidateRanked candidateRanked);

	@Select({
		"SELECT * FROM ranking ORDER BY CAST(score AS UNSIGNED) DESC;"
	})
	@Results(value = {
			@Result(property = "candidateId", column = "candidate_id"),
			@Result(property = "candidateLocation", column = "raking_location"),
			@Result(property = "candidateLevel", column = "raking_level"),
			@Result(property = "candidateScore", column = "score")
	})
	public List<CandidateRanked> selectRankingData();
	
}
