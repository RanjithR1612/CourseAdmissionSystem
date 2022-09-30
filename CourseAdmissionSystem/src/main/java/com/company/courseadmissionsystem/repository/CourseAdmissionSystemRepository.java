package com.company.courseadmissionsystem.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.company.courseadmissionsystem.model.Student;

@Repository
public interface CourseAdmissionSystemRepository extends MongoRepository<Student, String>{

	Student findByAadharNumber(Long aadharNumber);
	Student findByPhoneNumber(Long phoneNumber);
	Optional<Student> findById(String id);
}
