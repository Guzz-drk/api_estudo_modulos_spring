package com.gupan.estudo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gupan.estudo.dto.ClassStudentDTO;
import com.gupan.estudo.repository.ClassStudentRepository;

/**
 * @author Gustavo
 *
 */
@Service
public class ClassStudentService {

	@Autowired
	private ClassStudentRepository classStudentRepository;
	
	public Page<ClassStudentDTO> findAll(Pageable page){
		return classStudentRepository.findAll(page);
	}
	
	public void saveClassStudent(ClassStudentDTO classStudent) {
		classStudentRepository.save(classStudent);
	}
}
