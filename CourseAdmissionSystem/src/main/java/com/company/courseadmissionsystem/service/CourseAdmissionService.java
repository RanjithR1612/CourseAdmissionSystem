package com.company.courseadmissionsystem.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.company.courseadmissionsystem.dto.CourseAdmissionDto;
import com.company.courseadmissionsystem.feign.CourseAdmissionSystemFeignClient;
import com.company.courseadmissionsystem.model.Course;
import com.company.courseadmissionsystem.model.Student;
import com.company.courseadmissionsystem.repository.CourseAdmissionSystemRepository;

@Service
public class CourseAdmissionService {

	@Autowired
	CourseAdmissionSystemFeignClient CourseAdmissionClient;
	@Autowired
	CourseAdmissionSystemRepository courseAdmissionSystemRepository;

	public List<Course> getAllCourses() {
		return CourseAdmissionClient.getAllCourses();
	}

	public Student register(CourseAdmissionDto courseAdmissionDto) throws Exception {
		Course course = CourseAdmissionClient.getCourseById(courseAdmissionDto.getCourseId());
		Student student = new Student();
		Student existingStudent = courseAdmissionSystemRepository
				.findByAadharNumber(courseAdmissionDto.getAadharNumber());
		if (existingStudent != null) {
			throw new Exception("The aadharNumber is already exists");

		}
		student.setAadharNumber(courseAdmissionDto.getAadharNumber());
		student.setAge(courseAdmissionDto.getAge());
		student.setCourseId(courseAdmissionDto.getCourseId());
		Student existingPhoneNumber = courseAdmissionSystemRepository
				.findByPhoneNumber(courseAdmissionDto.getPhoneNumber());
		if (existingPhoneNumber != null) {
			throw new Exception("the phoneNumber is already exists");
		}
		student.setPhoneNumber(courseAdmissionDto.getPhoneNumber());
		student.setCourse(course);
		student.setStudentName(courseAdmissionDto.getStudentName());
		return courseAdmissionSystemRepository.save(student);

	}
	
	public Page<Student> getAllStudentsByPageable(){
		Pageable pageable = PageRequest.of(0, 20, Sort.by("StudentName"));
		Page<Student> students = courseAdmissionSystemRepository.findAll(pageable);
		return students;
		
	}
	
	public Map<String, Map<String, Integer>> getReport(){
		Map<String, Map<String, Integer>> reportMap = new TreeMap<>();
		Map<String, Integer> courseMap = new TreeMap<>();
		Map<String, Integer> categoryMap = new TreeMap<>();
		List<Student> students = courseAdmissionSystemRepository.findAll();
		for(Student student : students) {
			
			String courseName = student.getCourse().getName();
			Integer courseCount = courseMap.get(courseName);
			if(courseCount == null) {
				courseMap.put(courseName, 1);
			}else {
				courseMap.put(courseName, courseCount+1);
			}
			
			String courseCategory = student.getCourse().getCategory();
			Integer categoryCount = categoryMap.get(courseCategory);
			if(categoryCount == null) {
				
				categoryMap.put(courseCategory, 1);
			}else {
				
				categoryMap.put(courseCategory, categoryCount+1);
			}
			
		}
	 reportMap.put("course", courseMap);
	reportMap.put("category", categoryMap);	
	return reportMap;
		
		
	}
}
