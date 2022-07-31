package com.mhasan.redisdb.controller;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mhasan.redisdb.models.Student;
import com.mhasan.redisdb.repository.StudentRepository;
import com.mhasan.redisdb.repository.StudentRepositoryCRUD;
import com.mhasan.redisdb.service.StudentService;

@RestController
@RequestMapping("/student")
@EnableCaching
public class StudentController {

	@Autowired
	private StudentService studentService;

//	public StudentController(StudentRepository studentRepository) {
//		this.studentRepository = studentRepository;
//	}

//	@Caching(evict = {
//			@CacheEvict(value="STUDENT", allEntries=true),
//			@CacheEvict(value="STUDENTS", allEntries=true) })
	
	@Caching(evict = {
			@CacheEvict(value = "STUDENT", allEntries = true),
			@CacheEvict(value = "STUDENTS", allEntries = true)
	})
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Student addStudent(@RequestBody Student student) {

		return studentService.addStudent(student);
	}
	
	@Caching(evict = {
			@CacheEvict(value = "STUDENT", allEntries = true),
			@CacheEvict(value = "STUDENTS", allEntries = true)
	})
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		
		return studentService.updateStudent(student);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@Cacheable(key = "#studentId", value = "STUDENT")
	public Student getStudentById(@PathVariable(name = "id") Long studentId) {

		return studentService.getStudentById(studentId);
	}
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@Cacheable("STUDENTS")
	public Map<Long, Student> getAllStudent() {

		return studentService.getAllStudent();
	}
	
	@Caching(evict = {
			@CacheEvict(value = "STUDENT", allEntries = true),
			@CacheEvict(value = "STUDENTS", allEntries = true)
	})
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable(name = "id") Long id) {

		return studentService.deleteStudent(id);
	}

//	@Autowired
//	private StudentRepositoryCRUD studentRepositoryCRUD;
//	
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public Student addStudent(@RequestBody Student student) {
//
//		return studentRepositoryCRUD.save(student);
//	}
//	@RequestMapping(value = "/update", method = RequestMethod.PUT)
//	public Student updateStudent(@RequestBody Student student) {
//		
//		return studentRepositoryCRUD.save(student);
//	}
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public Student getStudentById(@PathVariable(name = "id") Long studentId) {
//
//		return studentRepositoryCRUD.findById(studentId).get();
//	}
//	@RequestMapping(value = "/all", method = RequestMethod.GET)
//	public List<Student> getAllStudent() {
//
//		return (List<Student>) studentRepositoryCRUD.findAll();
//	}
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//	public void deleteStudent(@PathVariable(name = "id") Long id) {
//
//		studentRepositoryCRUD.deleteById(id);
//	}
//	
	

}
