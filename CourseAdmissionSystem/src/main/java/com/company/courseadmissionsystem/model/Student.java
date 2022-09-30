package com.company.courseadmissionsystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Course-Admission-System-01")
public class Student {
	private String StudentName;
	private Long age;
	private Long phoneNumber;
	private Long aadharNumber;
	private String courseId;
	private Course course;
	@Id
	private String id;
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

}
