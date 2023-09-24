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
	
	@Query(nativeQuery = true, value = "select u.cd_user, u.nm_user, u.ds_mail, u.dt_birth, "
			+ "tu.ds_type_user as type_user, extract(year from age(current_date, u.dt_birth))\\:\\: int as age "
			+ "from class_student as cs "
			+ "right join users u  "
			+ "on cs.cd_user = u.cd_user  "
			+ "right join type_users tu "
			+ "on u.cd_type_user = tu.cd_type_user  "
			+ "where cs.cd_class = :cdClass  "
			+ "order by u.nm_user asc ")
	public Page<List<UserEntity>> getStudentsByClass(Pageable page, Long cdClass);
	
	@Query(nativeQuery = true, value = "select u.cd_user, u.nm_user, u.ds_mail, u.dt_birth, "
			+ "tu.ds_type_user as type_user, extract(year from age(current_date, u.dt_birth))\\:\\: int as age "
			+ "from class_teacher as ct "
			+ "right join users u  "
			+ "on ct.cd_user = u.cd_user  "
			+ "right join type_users tu "
			+ "on u.cd_type_user = tu.cd_type_user  "
			+ "where ct.cd_class = :cdClass  "
			+ "order by u.nm_user asc ")
	public Page<List<UserEntity>> getTeachersByClass(Pageable page, Long cdClass);
}
