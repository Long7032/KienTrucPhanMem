/**
 * 
 */
package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Student;

/**
 * 
 */
public interface StudentDAOImpl {

	public void addStudent(String key, Student s);
	public List<Student> getAll(String value);
	public Student findById(String key, String id);
	public void deleteStudentByID(String key, String id);
	public void updateStudentByID(String key, Student s);
}
