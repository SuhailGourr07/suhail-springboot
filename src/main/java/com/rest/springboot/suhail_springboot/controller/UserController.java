package com.rest.springboot.suhail_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.suhail_springboot.dao.UserRepository;
import com.rest.springboot.suhail_springboot.entity.User;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository UserRepository;
	
	public UserController(UserRepository UserRepository) {
		super();
		this.UserRepository = UserRepository;
	}
	
	
	@GetMapping
	public User hello() {
		System.out.println("Hello method");
		return new User(99,"Dummy","ptani","Not Found");
	}
	
	@GetMapping("/get-user/{id}")
	public Optional<User> getUserById(@PathVariable (name = "id") int id) {
		return UserRepository.findById(id);
	}
	
	@GetMapping("/all-users")
	public List<User> getAllUsers(){
		
		return UserRepository.findAll();
	}
	
	
	@PostMapping("/save-user")
	public User saveUser(@RequestBody User user) {
		
		return UserRepository.save(user);
	}
	
	@DeleteMapping("/delete-user/{id}")
	public String deleteUserById(@PathVariable(name="id") int id) {
		
		UserRepository.deleteById(id);
		return "User Deleted Successfully";
	}
	
	
	@PutMapping("/update-user/{id}")
	public User updateUser(@PathVariable(name = "id") int id, @RequestBody User updatedUser) {
		
		Optional<User> Optionaluser = UserRepository.findById(id);
		
		if(Optionaluser.isPresent()) {
			User user = Optionaluser.get();
			
			user.setName(updatedUser.getName());
			user.setAddress(updatedUser.getAddress());
			
			return UserRepository.save(user);
		}
		
		return null;
	}
}
