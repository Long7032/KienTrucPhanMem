/**
 * 
 */
package com.example.demo.dao;

import java.text.ParseException;
import java.util.List;

import com.example.demo.entity.Account;
import com.nimbusds.jose.JOSEException;

/**
 * 
 */
public interface AccountDAO {
	public void createAccount (String key, String field, Account a)throws ParseException, JOSEException;
	public List<Account> list(String key);
	public void login(String key, String field, Account a);
}
