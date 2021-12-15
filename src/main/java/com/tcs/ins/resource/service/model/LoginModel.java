package com.tcs.ins.resource.service.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginModel {

	@NotNull(message = "User id is Required")
	@Size(min = 4, max = 30)
	private String id;

	//@NotBlank(message = "Password is Required")
	@NotNull(message = "User id is Required")
	//@Size(min = 8, max = 20)
	private String password;
	@NotBlank(message = "First name is Required")
	private String firstName;
	@NotBlank(message = "Last name is Required")
	private String lastName;
	@NotBlank(message = "Email is Required")
	@Email
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LoginModel [id=" + id + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}
}
