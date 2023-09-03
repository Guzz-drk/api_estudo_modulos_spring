package com.gupan.estudo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gupan.estudo.dto.UserDTO;
import com.gupan.estudo.entity.UserEntity;
import com.gupan.estudo.repository.UserEntityRepository;
import com.gupan.estudo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public UserDTO saveStudent(UserDTO user) {
		user.setDsPassword(encoder.encode(user.getDsPassword()));
		user.setCdTypeUser(userRepository.getCdTypeUserStudent());
		return userRepository.save(user);
	}
	
	public UserDTO saveTeacher(UserDTO user) {
		user.setDsPassword(encoder.encode(user.getDsPassword()));
		user.setCdTypeUser(userRepository.getCdTypeUserTeacher());
		return userRepository.save(user);
	}
	
	public UserDTO saveDirector(UserDTO user) {
		user.setCdTypeUser(userRepository.getCdTypeUserDirector());
		user.setDsPassword(encoder.encode(user.getDsPassword()));
		return userRepository.save(user);
	}
	
	public Page<List<UserEntity>> getStudents(Pageable page) {
		return userEntityRepository.getListUsersStudents(page);
	}
	
	public Page<List<UserEntity>> getTeachers(Pageable page) {
		return userEntityRepository.getListUsersTeachers(page);
	}
	
	public Page<List<UserEntity>> getDirectors(Pageable page) {
		return userEntityRepository.getListUsersDirectors(page);
	}
}
