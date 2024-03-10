package com.example.demo.controler;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AccountDaoImpl;
import com.example.demo.entity.Account;
import com.nimbusds.jose.JOSEException;

@RestController
public class ControllerAccount {

	@Autowired
	private AccountDaoImpl accountDao;
	
	@RequestMapping("/")
	public String requestMethodName() {
		return new String("ok");
	}
	
	@RequestMapping("/create")
	public void createAccount(@RequestParam("key") String key,@RequestBody Account a) throws ParseException, JOSEException {
		accountDao.createAccount(key, a.getUserName(), a);
//		return new String("ok");
	}
	
	@RequestMapping("/getAll")
	public List<Account> getAll(@RequestParam("key") String key) {
		return accountDao.list(key);
	}
	
	
	
	
	
}
