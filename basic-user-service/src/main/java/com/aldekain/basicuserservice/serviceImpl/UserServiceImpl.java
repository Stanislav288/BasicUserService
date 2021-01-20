package com.aldekain.basicuserservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aldekain.basicuserservice.entities.User;
import com.aldekain.basicuserservice.models.bindingmodels.UserRegister;
import com.aldekain.basicuserservice.repository.UserRepository;
import com.aldekain.basicuserservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean register(UserRegister userRegister) {
		if (!userRegister.getPassword().equals(userRegister.getConfirmPassword())) {
			return false;
		}
		
		User user =  new User();
		user.setUsername(userRegister.getUsername());
		user.setPassword(passwordEncoder.encode(userRegister.getPassword()));
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
		return null;
	}

	@Override
	public List<User> findAll() {
		//return userRepository.findAll();
		return null;
	}

}
