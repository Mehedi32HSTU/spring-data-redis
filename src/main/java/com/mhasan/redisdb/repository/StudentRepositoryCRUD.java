package com.mhasan.redisdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mhasan.redisdb.models.Student;

@Repository
public interface StudentRepositoryCRUD extends CrudRepository<Student, Long>{

}
