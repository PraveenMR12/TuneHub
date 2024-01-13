package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NavController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/registration")
	public String registration() {
		return "register";
	}
	
	@GetMapping("/newSong")
	public String newSong() {
		return "new_song";
	}
	
//	@GetMapping("/logout")
//	public String logout() {
//		return "";
//	}
	

}
