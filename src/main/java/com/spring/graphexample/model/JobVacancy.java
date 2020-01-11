package com.spring.graphexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobVacancy {

	private int jobCompanyId;
	private String jobCompany;
	private String jobTitle;
	private String jobDescription;
	private String jobLocation;
	private int jobLevel;

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation.toUpperCase();
	}
	
}
