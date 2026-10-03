package com.rest.springboot.suhail_springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.suhail_springboot.entity.User;

@RestController
public class UserController {
	
	static Map<Integer,User> users = new HashMap<>();
	
	static {
		users.put(1, new User(1,"suhail","Male","Noida"));
		users.put(2, new User(2,"Shadab","Male","Riyadh"));
		users.put(3, new User(3,"sobi","Male","Delhi"));
		users.put(4, new User(4,"suahan","Female","Noida"));
	}

	@GetMapping
	public User hello() {
		System.out.println("Hello method");
		return new User(99,"Dummy","ptani","Not Found");
	}
	
	@GetMapping("/get-user/{id}")
	public User getUserById(@PathVariable (name = "id") int id) {
		return users.get(id);
	}
	
	@GetMapping("/all-users")
	public Map<Integer,User> getAllUsers(){
		
		return users;
	}
	
	
	@PostMapping("/save-user")
	public User saveUser(@RequestBody User user) {
		users.put(user.getId(), user);
		return user;
	}
	
	@DeleteMapping("/delete-user/{id}")
	public String deleteUserById(@PathVariable(name="id") int id) {
		users.remove(id);		
		return "User Deleted Successfully";
	}
	
	
	@PutMapping("/update-user/{id}")
	public String updateUser(@PathVariable(name = "id") int id, @RequestBody User updateUser) {
		
		User user = users.get(id);
		if(user != null) {
			user.setName(updateUser.getName());
			user.setAddress(updateUser.getAddress());
			
			return "User updated Successfully";
		}
		return "User Not Found";
	}
}
