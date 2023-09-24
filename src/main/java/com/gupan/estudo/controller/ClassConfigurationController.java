package com.gupan.estudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gupan.estudo.dto.ClassStudentDTO;
import com.gupan.estudo.dto.ClassTeacherDTO;
import com.gupan.estudo.service.ClassStudentService;
import com.gupan.estudo.service.ClassTeacherService;

/**
 * @author Gustavo
 *
*/

@RestController
@RequestMapping(value = "/classConfiguration")
public class ClassConfigurationController {

	@Autowired
	private ClassStudentService classStudentService;
	
	@Autowired
	private ClassTeacherService classTeacherService;
	
	@GetMapping(value = "/classesStudents")
	public Page<ClassStudentDTO> findAllClassesStudents(Pageable page){
		return classStudentService.findAll(page);
	}
	
	@PostMapping(value = "/classStudent")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveClassStudent(@RequestBody ClassStudentDTO classStudent) {
		classStudentService.saveClassStudent(classStudent);
	}
	
	@GetMapping(value = "/classesTeachers")
	public Page<ClassTeacherDTO> findAllClassesTeachers(Pageable page){
		return classTeacherService.findAll(page);
	}
	
	@PostMapping(value = "/classTeacher")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveClassTeacher(@RequestBody ClassTeacherDTO classTeacher) {
		classTeacherService.saveClassTeacher(classTeacher);
	}
}
