package com.gupan.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.gupan.estudo.dto.UserDTO;

public interface UserRepository extends JpaRepository<UserDTO, Long>{

	UserDetails findByDsMail(String dsMail);
}
