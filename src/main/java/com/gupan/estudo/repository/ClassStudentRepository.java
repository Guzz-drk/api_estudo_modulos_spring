package com.gupan.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gupan.estudo.dto.ClassStudentDTO;

/**
 * @author Gustavo
 *
 */
@Repository
public interface ClassStudentRepository extends JpaRepository<ClassStudentDTO, Long>{

}
