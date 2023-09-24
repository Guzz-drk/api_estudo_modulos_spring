package com.gupan.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gupan.estudo.dto.ClassTeacherDTO;

/**
 * @author Gustavo
 *
*/
@Repository
public interface ClassTeacherRepository extends JpaRepository<ClassTeacherDTO, Long>{

}
