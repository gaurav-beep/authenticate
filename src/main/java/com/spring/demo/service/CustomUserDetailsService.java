package com.spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.demo.model.CustomUserDetails;
import com.spring.demo.model.UserModel;
import com.spring.demo.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user=new UserModel();
		try {
			user = userRepository.findById(username).get();
			 return new CustomUserDetails(user);
		} catch (Exception e) {
			 return new CustomUserDetails();
		}
	}

}
