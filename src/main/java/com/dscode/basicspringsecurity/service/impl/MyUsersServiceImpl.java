package com.dscode.basicspringsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dscode.basicspringsecurity.domain.MyUsersDetails;
import com.dscode.basicspringsecurity.domain.Users;
import com.dscode.basicspringsecurity.repository.UsersRepository;

@Service
public class MyUsersServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsersRepository usersRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users=usersRepository.findByUsername(username);
		if (users == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
		return new MyUsersDetails(users);
	}

}
