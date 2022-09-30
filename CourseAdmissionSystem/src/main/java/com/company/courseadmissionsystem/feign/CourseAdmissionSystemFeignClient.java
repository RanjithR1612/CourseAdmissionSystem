package com.company.courseadmissionsystem.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.company.courseadmissionsystem.model.Course;

@FeignClient(name="CourseAdmissionClient", url = "https://f2ba-49-207-207-8.in.ngrok.io")
public interface CourseAdmissionSystemFeignClient {
	
	@GetMapping("/courses")
	public List<Course> getAllCourses();
	
	@GetMapping("course/{id}")
	public Course getCourseById(@PathVariable("id") String id);

}
