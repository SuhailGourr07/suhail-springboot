package com.rest.springboot.suhail_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.suhail_springboot.dao.UserRepository;
import com.rest.springboot.suhail_springboot.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository UserRepository;

	public UserService(UserRepository UserRepository) {
		super();
		this.UserRepository = UserRepository;
	}

	//getUserById
	public Optional<User> getUserById(int id) {

		return UserRepository.findById(id);
	}
	
	//get-all-users
	public List<User> getAllUsers() {
		return UserRepository.findAll();
	}

	
	//save
	public User saveUser(User user) {
		return UserRepository.save(user);
	}

	//delete
	public void deleteUserById(int id) {

		UserRepository.deleteById(id);
	}

	
	//update
	public User updateUser(int id, User updatedUser) {

		Optional<User> Optionaluser = UserRepository.findById(id);

		if (Optionaluser.isPresent()) {
			User user = Optionaluser.get();

			user.setName(updatedUser.getName());
			user.setAddress(updatedUser.getAddress());

			return UserRepository.save(user);
		}

		return null;
	}
}
