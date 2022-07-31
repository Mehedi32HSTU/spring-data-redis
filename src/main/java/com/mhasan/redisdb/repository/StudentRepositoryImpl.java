package com.mhasan.redisdb.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.mhasan.redisdb.models.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	public static final String Key = "STUDENT";
	
	private RedisTemplate<Long, Student> redisTemplate;

	private HashOperations hashOperations;

//	"STUDENT" is the key (Common Key.) (H)
//	studentId is the hashKey. (HK)
//	Student object is the hashValue. (HV)

	public StudentRepositoryImpl(RedisTemplate<Long, Student> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public Student save(Student student) {
		hashOperations.put(Key, student.getStudentId(), student);

		return student;
	}

	@Override
	public Student findById(Long id) {

		return (Student) hashOperations.get(Key, id);
	}

	@Override
	public Map<Long, Student> findAll() {

		return hashOperations.entries(Key);
	}

	@Override
	public Student update(Student student) {

		return save(student);
	}

	@Override
	public String deleteById(Long id) {
		hashOperations.delete(Key, id);
		return "Deleted Successfully with id : "+id;
	}

}
