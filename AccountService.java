package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
		
		@Autowired
		AccountRepository repository;
		
		public void Save(Account account)
		{
			repository.save(account);
			System.out.println("Account  : "+ account );
		}
		public List<Account> getUsers() {
			return repository.findAll();
	      
			
		}

	}