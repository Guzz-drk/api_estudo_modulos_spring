package com.gupan.estudo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gupan.estudo.dto.ClassTeacherDTO;
import com.gupan.estudo.repository.ClassTeacherRepository;

/**
 * @author Gustavo
 *
*/
@Service
public class ClassTeacherService {

	@Autowired
	private ClassTeacherRepository classTeacherRepository;
	
	public Page<ClassTeacherDTO> findAll(Pageable page){
		return classTeacherRepository.findAll(page);
	}
	
	public void saveClassTeacher(ClassTeacherDTO classTeacher) {
		classTeacherRepository.save(classTeacher);
	}
}
