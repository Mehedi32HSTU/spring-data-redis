package com.mhasan.redisdb.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mhasan.redisdb.models.Student;
import com.mhasan.redisdb.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(Student student) {
		System.out.println("addStudent Service Called.");

		return studentRepository.save(student);
	}
	public Student updateStudent(Student student) {
		System.out.println("updateStudent Service Called.");
		return studentRepository.update(student);
	}
	public Student getStudentById(Long studentId) {
		System.out.println("getStudentById Service Called.");
		return studentRepository.findById(studentId);
	}
	public Map<Long, Student> getAllStudent() {
		System.out.println("getAllStudent Service Called.");
		return studentRepository.findAll();
	}

	public String deleteStudent(Long id) {
		System.out.println("deleteStudent Service Called.");
		return studentRepository.deleteById(id);
	}

}
