package com.gupan.estudo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gupan.estudo.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{

	@Query(nativeQuery = true, value = "select  users.cd_user, users.nm_user, "
			+ "users.ds_mail, users.dt_birth, type_users.ds_type_user as type_user, "
			+ "extract(year from age(current_date, users.dt_birth))\\:\\: int as age "
			+ "from users left join type_users  "
			+ "ON type_users.cd_type_user = users.cd_type_user  "
			+ "where type_users.ds_type_user ilike 'aluno%' "
			+ "order by users.dt_birth")
	public Page<List<UserEntity>> getListUsersStudents(Pageable page);
	
	@Query(nativeQuery = true, value = "select  users.cd_user, users.nm_user,  "
			+ "users.ds_mail, users.dt_birth, type_users.ds_type_user as type_user,  "
			+ "extract(year from age(current_date, users.dt_birth))\\:\\: int as age  "
			+ "from users left join type_users   "
			+ "ON type_users.cd_type_user = users.cd_type_user   "
			+ "where type_users.ds_type_user ilike 'professor%'  "
			+ "order by users.dt_birth")
	public Page<List<UserEntity>> getListUsersTeachers(Pageable page);
	
	@Query(nativeQuery = true, value = "select  users.cd_user, users.nm_user,  "
			+ "users.ds_mail, users.dt_birth, type_users.ds_type_user as type_user,  "
			+ "extract(year from age(current_date, users.dt_birth))\\:\\: int as age  "
			+ "from users left join type_users   "
			+ "ON type_users.cd_type_user = users.cd_type_user   "
			+ "where type_users.ds_type_user ilike 'diretor%'  "
			+ "order by users.dt_birth")
	public Page<List<UserEntity>> getListUsersDirectors(Pageable page);
}
