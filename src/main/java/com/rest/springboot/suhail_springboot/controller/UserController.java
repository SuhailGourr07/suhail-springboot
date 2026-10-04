package com.rest.springboot.suhail_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.suhail_springboot.entity.User;
import com.rest.springboot.suhail_springboot.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping
	public User hello() {
		System.out.println("Hello method");
		return new User(99,"Dummy","ptani","Not Found");
	}
	
	@GetMapping("/get-user/{id}")
	public Optional<User> getUserById(@PathVariable (name = "id") int id) {
		
		return userService.getUserById(id);
	}
	
	@GetMapping("/all-users")
	public List<User> getAllUsers(){
		
		return userService.getAllUsers();
	}
	
	
	@PostMapping("/save-user")
	public User saveUser(@RequestBody User user) {
		
		return userService.saveUser(user);
	}
	
	@DeleteMapping("/delete-user/{id}")
	public String deleteUserById(@PathVariable(name="id") int id) {
		
		userService.deleteUserById(id);
		return "User Deleted Successfully";
	}
	
	
	@PutMapping("/update-user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(name = "id") int id, @RequestBody User updatedUser) {
		
		User user = userService.updateUser(id,updatedUser);
		
		if(user!= null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.notFound().build();
	}
}
