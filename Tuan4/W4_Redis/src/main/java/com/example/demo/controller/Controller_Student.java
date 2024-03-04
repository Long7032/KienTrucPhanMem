package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.StudentDAOImpl;
import com.example.demo.entity.Student;


@RestController
public class Controller_Student {

	@Autowired
	private StudentDAOImpl studentDAO;
	
	
	
	
	@GetMapping("/")
	public String home() {
		return "ok";
	}
	
	@GetMapping("/save")
	public void saveStudent(@RequestBody Student s,
			@RequestParam("key") String key) {
		
		studentDAO.addStudent(key, s);
		System.out.println("Save");
	}
	
	@GetMapping("/findAll")
	public List<Student> getAllStudent(@RequestParam("key") String key){
		System.out.println("Param: " + key);
		return studentDAO.getAll(key);
	}
	
	@GetMapping("/findById")
	public Student getStudentByID(@RequestParam("key") String key,
			@RequestParam("id") String id){
		System.out.println("Param: " + key);
		return studentDAO.findById(key, id);
	}
	
	@GetMapping("/update")
	public void updateStudent(@RequestBody Student s,
			@RequestParam("key") String key) {
		
		studentDAO.updateStudentByID(key, s);
		System.out.println("Update");
	}
	
	@GetMapping("/delete")
	public void deleteStudent(@RequestParam("id") String id,
			@RequestParam("key") String key) {
		
		studentDAO.deleteStudentByID(key, id);
		System.out.println("Update");
	}
	
	
	
}


