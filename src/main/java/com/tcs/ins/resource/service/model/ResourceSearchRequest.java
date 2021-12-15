package com.tcs.ins.resource.service.model;

import java.util.Map;

import org.springframework.util.StringUtils;

public class ResourceSearchRequest {
	
	private static final String REQUEST_PARAM_ID = "id";

	private static final String REQUEST_PARAM_FIRSTNAME = "firstName";
	private static final String REQUEST_PARAM_LASTNAME = "lastName";
	private static final String REQUEST_PARAM_EXP = "experience";

	private final Long id;

	private final String firstName;
	private final String lastName;
	private final String experience;

	public ResourceSearchRequest(Map<String, String> requestParam) {
		String idStr = requestParam.get(REQUEST_PARAM_ID);
		if (StringUtils.hasText(idStr)) {
			this.id = Long.valueOf(idStr);
		} else {
			this.id = null;
		}
		this.firstName = requestParam.get(REQUEST_PARAM_FIRSTNAME);
		this.lastName = requestParam.get(REQUEST_PARAM_LASTNAME);
		this.experience = requestParam.get(REQUEST_PARAM_EXP);
	}

	public boolean idFilteringRequired() {
		return id != null;
	}

	public boolean firstNameFilteringRequired() {
		return StringUtils.hasText(firstName);
	}

	public boolean lastNameFilteringRequired() {
		return StringUtils.hasText(lastName);
	}

	public boolean experienceFilteringRequired() {
		return StringUtils.hasText(experience);
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

	public Long getId() {
		return id;
	}
}
