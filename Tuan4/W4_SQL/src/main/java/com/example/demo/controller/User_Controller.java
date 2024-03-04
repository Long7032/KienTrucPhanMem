package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.User;
import com.example.demo.repository.User_Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController()
public class User_Controller {
	@Autowired 
	private User_Repository user_Repository;
	
	
	@GetMapping("getAllUsers")
	public String home() throws JsonProcessingException {
		List<User> ls = user_Repository.findAll();
		ObjectMapper mapper = new ObjectMapper();
//		http://localhost:8183/getAllUsers
		
		
		
		return mapper.writeValueAsString(ls);
		
	}
}
