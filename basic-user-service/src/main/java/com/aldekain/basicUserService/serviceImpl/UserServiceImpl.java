package com.aldekain.basicUserService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aldekain.basicUserService.entities.User;
import com.aldekain.basicUserService.models.bindingModels.UserRegister;
import com.aldekain.basicUserService.repository.UserRepository;
import com.aldekain.basicUserService.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean register(UserRegister userRegister) {
		if (!userRegister.getPassword().equals(userRegister.getConfirmPassword())) {
			return false;
		}
		
		User user =  new User();
		user.setUsername(userRegister.getUsername());
		user.setPassword(userRegister.getPassword());
		user.setEmail(userRegister.getEmail());
		
		this.userRepository.saveAndFlush(user);
		
		return true;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userRepository.findFirstByUsername(username);
	}

	@Override
	public User findOne(long id) {
		//return this.userRepository.findById(id).get();
		return null;
	}

	@Override
	public List<User> findAll() {
		//return userRepository.findAll();
		return null;
	}

}
