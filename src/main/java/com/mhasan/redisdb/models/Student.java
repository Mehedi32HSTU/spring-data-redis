package com.mhasan.redisdb.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

//@RedisHash("Student")
public class Student implements Serializable{
	@Id
	private Long studentId;
	private String name;
	private String currentClass;
	private String section;

	public Student(Long studentId, String name, String currentClass, String section) {
		this.studentId = studentId;
		this.name = name;
		this.currentClass = currentClass;
		this.section = section;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrentClass() {
		return currentClass;
	}
	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", currentClass=" + currentClass + ", section="
				+ section + "]";
	}

}
