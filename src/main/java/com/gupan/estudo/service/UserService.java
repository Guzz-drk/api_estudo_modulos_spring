package com.gupan.estudo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gupan.estudo.dto.UserDTO;
import com.gupan.estudo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public UserDTO salvar(UserDTO user) {
		user.setDsPassword(encoder.encode(user.getDsPassword()));
		return userRepository.save(user);
	}
}
