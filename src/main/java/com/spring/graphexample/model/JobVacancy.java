package com.spring.graphexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobVacancy {

	private String jobCompany;
	private String jobTitle;
	private String jobDescription;
	private String jobLocation;
	private Integer jobLevel;
	
}
