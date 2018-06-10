package edu.iss.ca.service;

import java.util.ArrayList;

import edu.iss.ca.models.User;

public interface UserService {
	
	ArrayList<User> findAllUser();

	User findUser(Integer id);

	User createUser(User name);

	User changeUser(User name);

	void removeUser(User name);

}
