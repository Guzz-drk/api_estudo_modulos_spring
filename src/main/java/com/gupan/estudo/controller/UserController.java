package com.gupan.estudo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gupan.estudo.dto.UserDTO;
import com.gupan.estudo.entity.UserEntity;
import com.gupan.estudo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/student")
	public UserDTO insertStudent(@RequestBody UserDTO user) {
		return userService.saveStudent(user);
	}
	
	@GetMapping(value = "/studenties")
	public Page<List<UserEntity>> getListStudents(Pageable page){
		return userService.getStudents(page);
	}
	
	@PostMapping(value = "/teacher")
	public UserDTO insertTeacher(@RequestBody UserDTO user) {
		return userService.saveTeacher(user);
	}
	
	@GetMapping(value = "/teachers")
	public Page<List<UserEntity>> getListTeachers(Pageable page){
		return userService.getTeachers(page);
	}
	
	@PostMapping(value = "/director")
	public UserDTO insertDirector(@RequestBody UserDTO user) {
		return userService.saveDirector(user);
	}
	
	@GetMapping(value = "/directors")
	public Page<List<UserEntity>> getListDirectors(Pageable page){
		return userService.getDirectors(page);
	}
}
