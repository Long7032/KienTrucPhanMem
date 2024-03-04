package com.example.demo.entity;

import java.io.Serializable;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;


@RedisHash("Student")
public class Student 
implements Serializable
{

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String name;

	private String grade;

	private String contactNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Student(String id, String name, String grade, String contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", grade='" + grade + '\'' + ", contactNo='"
				+ contactNo + '\'' + '}';
	}
}
