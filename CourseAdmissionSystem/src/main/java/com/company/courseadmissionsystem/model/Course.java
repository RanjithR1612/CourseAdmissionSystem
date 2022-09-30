package com.company.courseadmissionsystem.model;

public class Course {
	private String name;
	private String department;
	private String category;
	private Long numberOfSemesters;
	private Long durationInYears;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getNumberOfSemesters() {
		return numberOfSemesters;
	}
	public void setNumberOfSemesters(Long numberOfSemesters) {
		this.numberOfSemesters = numberOfSemesters;
	}
	public Long getDurationInYears() {
		return durationInYears;
	}
	public void setDurationInYears(Long durationInYears) {
		this.durationInYears = durationInYears;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
