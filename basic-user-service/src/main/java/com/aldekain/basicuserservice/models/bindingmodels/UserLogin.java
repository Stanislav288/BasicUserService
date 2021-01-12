package com.aldekain.basicuserservice.models.bindingmodels;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class UserLogin {
	
	@Size(min = 4, max = 20, message = "Username size must be between 4 and 20 symbols long")
	private String username;
	
	@Min(value=8,message="Passsword has to be atleast 8 symbols long")
	private String password;
	
	public UserLogin() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
