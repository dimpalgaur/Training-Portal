package com.Training.trainingPortal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Training.trainingPortal.model.User;
import com.Training.trainingPortal.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService
{

	@Autowired
	UserRepository userRepo;
	 
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException 
	{
		//User user = this.userRepo.findByEmail(userName).orElseThrow(() -> new ResourceNotFoundException("user","email : "+userName, 0));
    	User user = this.userRepo.findByEmail(userName).orElseThrow();
	    return user;
	}

}
