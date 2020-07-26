package com.aldekain.basicUserService.models.bindingModels;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.aldekain.basicUserService.annotations.PasswordMatches;

@PasswordMatches
public class UserRegister {

	@Size(min = 4, max = 20, message = "Username size must be between 4 and 20 symbols long")
	private String username;
	
	@Email(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",message = "Email is not in valid format")
	private String email;
	
	@Min(value=8,message="Passsword has to be atleast 8 symbols long")
	private String password;
	
	private String confirmPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
