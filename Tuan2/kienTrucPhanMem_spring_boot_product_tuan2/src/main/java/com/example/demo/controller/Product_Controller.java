package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
public class Product_Controller {
	@Autowired
	private ProductRepository productRepository;
	
	private RestTemplate restTemplate = new RestTemplate();
	@GetMapping("/")
	public String requestMethodName() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		List<Product> ls = productRepository.findAll();
		
		String url = "http://localhost:8183/getAllUsers";

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		HashMap<String, String> hs= new HashMap<>();
		hs.put("user", mapper.writeValueAsString(response.getBody()));
		hs.put("produuct", mapper.writeValueAsString(ls));
		
		return mapper.writeValueAsString(hs);
		
	}
	
}
