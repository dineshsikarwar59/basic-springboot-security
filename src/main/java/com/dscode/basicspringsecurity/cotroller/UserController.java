package com.dscode.basicspringsecurity.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dscode.basicspringsecurity.domain.Users;
import com.dscode.basicspringsecurity.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return userService.register(user);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasRole('ADMIN')")
	public Users update(@RequestBody Users user) {
		return userService.update(user);
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('USER')")
	public List<Users> getUsers(){
		return userService.getUsers();
	}

}
