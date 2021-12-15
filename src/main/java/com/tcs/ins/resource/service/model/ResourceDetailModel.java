package com.tcs.ins.resource.service.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResourceDetailModel {

	private Long id;

	private String firstName;
	private String lastName;
	private String experience;
	private String designation;
	private String skills;
	private String email;
	private String performanceRate;
	
	//@NotBlank(message = "Start Date is Mandatory")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dOJ;

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getExperience() {
		return experience;
	}

	public String getDesignation() {
		return designation;
	}

	public String getSkills() {
		return skills;
	}

	public String getEmail() {
		return email;
	}

	public String getPerformanceRate() {
		return performanceRate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPerformanceRate(String performanceRate) {
		this.performanceRate = performanceRate;
	}

	public LocalDateTime getdOJ() {
		return dOJ;
	}

	public void setdOJ(LocalDateTime dOJ) {
		this.dOJ = dOJ;
	}
}
