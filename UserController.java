package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")

@RestController
public class UserController {   //POJO
	
	@Autowired
	UserService userService;  //dependency
	
	@GetMapping("/")
	List<User> getUsers() {
		
		System.out.println("getUsers called..........");
		return userService.getUsers();
	}
	
	@GetMapping("/{id}")
	void getUser(@PathVariable Integer id)
	{
		System.out.println("getUser called........" + id);
	}
	
//	void postCall()
//	{
//		System.out.println("Called Post method.........");
//	}
	@PostMapping
	String saveUser(@RequestBody User user)
	{
		userService.save(user);
		System.out.println("User : " + user.getName());
		return "Post Called";
	}
	
//	@PutMapping
//	void putCall()
//	{
//		System.out.println("Put method");
//	}
	
	@PutMapping
	String putCall()
	{
		System.out.println("calling PUT ..........");
		return "Put Method called";
	}

	
	

}
