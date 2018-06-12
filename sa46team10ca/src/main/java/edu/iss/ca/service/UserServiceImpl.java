package edu.iss.ca.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.ca.models.User;
import edu.iss.ca.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	@Transactional
	public ArrayList<User> findAllUser() {
		return (ArrayList<User>) userRepository.findAll();
	}

	@Override
	@Transactional
	public User findUser(Integer id) {
		return userRepository.findOne(id);
	}

	@Override
	@Transactional
	public User createUser(User name) {
		return userRepository.saveAndFlush(name);
	}

	@Override
	@Transactional
	public User changeUser(User name) {
		return userRepository.saveAndFlush(name);
	}

	@Override
	@Transactional
	public void removeUser(User name) {
		userRepository.delete(name);
	}

}
