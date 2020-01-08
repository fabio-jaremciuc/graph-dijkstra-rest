package com.spring.graphexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSuccessResp {

	private String status;
	private String message;
	private JobVacancy data;

	public JobSuccessResp jobSuccess(JobVacancy jobVacancy) {
		return new JobSuccessResp("Success!", "New Entry!", jobVacancy);
	}
}