package com.gupan.estudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gupan.estudo.dto.UserDTO;
import com.gupan.estudo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserDTO inserir(@RequestBody UserDTO user) {
		return userService.salvar(user);
	}
	
}
