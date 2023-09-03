package com.gupan.estudo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gupan.estudo.dto.ClassDTO;
import com.gupan.estudo.service.ClassService;

@RestController
@RequestMapping(value = "/classes")
public class ClassController {

	@Autowired
	private ClassService classService;
	
	@PostMapping
	public ClassDTO insertClass(@RequestBody ClassDTO classDTO) {
		return classService.save(classDTO);
	}
	
	@GetMapping
	public Page<List<ClassDTO>> getListClasses(Pageable page){
		return classService.getListClasses(page);
	}
}
