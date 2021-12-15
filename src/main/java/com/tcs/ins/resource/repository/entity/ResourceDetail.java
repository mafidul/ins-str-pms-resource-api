package com.tcs.ins.resource.repository.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

@Entity(name = "RESOURCEDETAIL")
@Audited
public class ResourceDetail extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "EXPERIENCE")
	private String experience;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "SKILL")
	private String skills;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PERFORMANCERATE")
	private String performanceRate;

	@Column(name = "DATEOFJOINING")
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
