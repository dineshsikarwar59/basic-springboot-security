package com.dscode.basicspringsecurity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dscode.basicspringsecurity.domain.Users;
import com.dscode.basicspringsecurity.repository.UsersRepository;
import com.dscode.basicspringsecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UsersRepository usersRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public Users register(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		usersRepository.save(user);
		return user;
	}
	
	@Override
	public Users update(Users user) {
		return usersRepository.save(user);
	}
	
	@Override
	public List<Users> getUsers() {
		return usersRepository.findAll();
	}

}
