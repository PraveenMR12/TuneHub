package com.example.demo.service;

import com.example.demo.entities.Users;

public interface UsersService {
	
	String addUser(Users user);
	boolean emailExists(String email);
	boolean validateUser(String email, String password);
	String getRole(String email);

	public Users getUser(String email);
	public void updateUser(Users user);
}
