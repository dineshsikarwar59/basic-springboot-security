package com.dscode.basicspringsecurity.cotroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dscode.basicspringsecurity.domain.Employee;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TestController {
	
	List<Employee> list=new ArrayList<Employee>();
	
	@GetMapping("/test")
	public String test(HttpServletRequest request) {
		return "Welcome to Home:"+request.getSession().getId();
	}
	
	@GetMapping("/all")
	public List<Employee> testEmployee() {
		return list;
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		list.add(employee);
		return employee;
	}
	
	@GetMapping("/csrf")
	public CsrfToken  getCsrf(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
		
	}


}
