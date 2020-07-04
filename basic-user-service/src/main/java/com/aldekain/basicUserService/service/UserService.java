package com.aldekain.basicUserService.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.aldekain.basicUserService.entities.User;
import com.aldekain.basicUserService.models.bindingModels.UserRegister;

public interface UserService extends  UserDetailsService{

	User findOne(long id);
	
	List<User> findAll();
	
    boolean register(UserRegister userRegister);
}
