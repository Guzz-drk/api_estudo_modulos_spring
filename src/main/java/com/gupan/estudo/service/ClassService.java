package com.gupan.estudo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gupan.estudo.dto.ClassDTO;
import com.gupan.estudo.repository.ClassRepository;

@Service
public class ClassService {

	@Autowired
	private ClassRepository classRepository;
	
	public ClassDTO save(ClassDTO classDTO) {
		return classRepository.save(classDTO);
	}
	
	public Page<List<ClassDTO>> getListClasses(Pageable page){
		return classRepository.getListClasses(page);
	}
	
	public List<ClassDTO> findAll(){
		return classRepository.findAll();
	}
}
