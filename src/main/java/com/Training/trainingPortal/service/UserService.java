package com.Training.trainingPortal.service;

import java.util.List;
import java.util.Optional;

import com.Training.trainingPortal.model.User;

public interface UserService 
{
	List<User> getAllUser();

	Optional<User> getUserById(int id);

	User saveUser(User user);

	User updateUser(User user);

	void deleteUser(Integer uId);

}
