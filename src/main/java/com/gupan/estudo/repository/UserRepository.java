package com.gupan.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.gupan.estudo.dto.UserDTO;

public interface UserRepository extends JpaRepository<UserDTO, Long>{

	UserDetails findByDsMail(String dsMail);
	
	@Query(nativeQuery = true, value = "select cd_type_user from type_users where ds_type_user ilike 'aluno%'")
	public Long getCdTypeUserStudent();
	
	@Query(nativeQuery = true, value = "select cd_type_user from type_users where ds_type_user ilike 'professor%'")
	public Long getCdTypeUserTeacher();
	
	@Query(nativeQuery = true, value = "select cd_type_user from type_users where ds_type_user ilike 'diretor%'")
	public Long getCdTypeUserDirector();
	
	@Query(nativeQuery = true, value = "select cd_type_user "
			+ "from users u where u.ds_mail = :mail")
	public Long getCdTypeUserByDsEmail(String mail);
}
