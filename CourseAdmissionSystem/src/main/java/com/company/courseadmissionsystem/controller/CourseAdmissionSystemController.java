package com.company.courseadmissionsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.courseadmissionsystem.dto.CourseAdmissionDto;
import com.company.courseadmissionsystem.model.Course;
import com.company.courseadmissionsystem.model.Student;
import com.company.courseadmissionsystem.service.CourseAdmissionService;

@RestController
public class CourseAdmissionSystemController {

	@Autowired
	CourseAdmissionService service;

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody CourseAdmissionDto courseAdmissionDto){
		try {
			return new  ResponseEntity<>(service.register(courseAdmissionDto), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
		
@GetMapping("/students/byPageable")		
public ResponseEntity<Page<Student>> getAllStudentsByPageination(){
			return new ResponseEntity<>(service.getAllStudentsByPageable(), HttpStatus.OK);
		}

@GetMapping("/report")
public ResponseEntity<Map<String, Map<String, Integer>>> getReport(){
	return new ResponseEntity<>(service.getReport(), HttpStatus.OK);
}
	}

