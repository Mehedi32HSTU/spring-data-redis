package com.mhasan.redisdb.repository;

import java.util.Map;

import com.mhasan.redisdb.models.Student;

public interface StudentRepository {

	Student save(Student student);
	Student findById(Long id);
	Map<Long, Student> findAll();
	Student update(Student student);
	String deleteById(Long id);


}
