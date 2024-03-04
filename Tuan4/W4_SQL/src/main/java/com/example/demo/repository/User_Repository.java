package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface User_Repository extends JpaRepository<User, Integer>{

	public List<User> findAll();
}
