package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.service.UsersService;

import jakarta.servlet.http.HttpSession;


@Controller
public class UsersController {
	@Autowired
	UsersService service;
	
	
	
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user) {
		boolean userStatus = service.emailExists(user.getEmail());
		if(userStatus==false) {
			service.addUser(user);
			System.out.print("User Added");
			String role = user.getRole();
			if(role.equals("admin")) {
				return "admin_home";
			}else {
				return "customer_home";
			}
		}else {
			System.out.print("User Exist with this email id");
			return "register";
		}
		
	}
	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password, 
			HttpSession session) {
		if(service.validateUser(email, password)) {
			String role = service.getRole(email);
			
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
				return "admin_home";
			}else {
				return "customer_home";
			}
		}else{
			return "login";
		}

	}
//	
//	@GetMapping("/pay")
//	public String pay(@RequestParam String email) {
//		
//		boolean paymentStatus=false;
//		if(paymentStatus==true) {
//			Users user = service.getUser(email);
//			user.setPremium(true);
//			service.updateUser(user);
//		}
//		return "login";
//	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "";
	}

}
