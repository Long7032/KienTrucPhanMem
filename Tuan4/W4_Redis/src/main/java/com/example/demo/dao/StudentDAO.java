package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public class StudentDAO implements StudentDAOImpl{

	@Autowired
	 private RedisTemplate template;
	private HashOperations hashOperations 
//	= template.opsForHash();
	;
	

	public StudentDAO(RedisTemplate template) {
		super();
		this.template = template;
		this.hashOperations = template.opsForHash();
	}

	@Override
	public void addStudent(String key, Student s) {
		// TODO Auto-generated method stub
//		hashOperations = template.opsForHash();
		System.out.println("DAO: " + s);
		hashOperations.put(key, s.getId(), s);
	}

	@Override
	public List<Student> getAll(String value) {
		// TODO Auto-generated method stub
//		hashOperations = template.opsForHash();
		System.out.println("Find All: " + hashOperations.values(value));
		return hashOperations.values(value);
	}

	@Override
	public Student findById(String key, String id) {
		// TODO Auto-generated method stub
		return (Student) hashOperations.get(key, id);
	}

	@Override
	public void deleteStudentByID(String key, String id) {
		// TODO Auto-generated method stub
		 hashOperations.delete(key, id);
		
	}

	@Override
	public void updateStudentByID(String key, Student s) {
		// TODO Auto-generated method stub
		addStudent(key, s);
	}

}
