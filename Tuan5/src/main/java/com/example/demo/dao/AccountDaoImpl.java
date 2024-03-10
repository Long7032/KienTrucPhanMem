/**
 * 
 */
package com.example.demo.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;
import com.nimbusds.jose.JOSEException;

import util.JWTUtil;

/**
 * 
 */
@Repository
public class AccountDaoImpl implements AccountDAO{

	@Autowired
	 private RedisTemplate template;
	private HashOperations hashOperations ;
	
	
	
	public AccountDaoImpl(RedisTemplate template) {
		super();
		this.template = template;
		this.hashOperations = template.opsForHash();
	}

	@Override
	public void createAccount(String key, String field, Account a) throws ParseException, JOSEException {
		// TODO Auto-generated method stub
		hashOperations.put(key, a.getUserID(), a);
		hashOperations.put("JWT", a.getUserID(), new JWTUtil().createJWT(a.getUserID(), a.getUserName(), a.getPassword(),360000));
}

	@Override
	public void login(String key, String field, Account a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> list(String key) {
		// TODO Auto-generated method stub
		System.out.println("List Acount: ");
		System.out.println(hashOperations.values(key));
		System.out.println("List Acount: ");
		System.out.println(hashOperations.values("JWT"));
		return hashOperations.values(key);
	}
	
}
