package com.aldekain.basicuserservice.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.aldekain.basicuserservice.entities.User;
import com.aldekain.basicuserservice.models.bindingmodels.UserRegister;

public interface UserService extends  UserDetailsService{

	User findOne(long id);
	
	List<User> findAll();
	
    boolean register(UserRegister userRegister);
}
