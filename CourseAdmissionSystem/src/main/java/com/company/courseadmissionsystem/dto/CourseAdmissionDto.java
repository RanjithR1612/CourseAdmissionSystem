package com.company.courseadmissionsystem.dto;

public class CourseAdmissionDto {
	private String StudentName;
	private Long age;
	private Long phoneNumber;
	private Long aadharNumber;
	private String courseId;
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

}
