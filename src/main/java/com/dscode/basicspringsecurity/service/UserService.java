package com.dscode.basicspringsecurity.service;

import java.util.List;

import com.dscode.basicspringsecurity.domain.Users;

public interface UserService {
	
	public Users register(Users user);

	public Users update(Users user);

	public List<Users> getUsers();

}
