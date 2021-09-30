package com.example.demo;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;

	ArrayList<Account> accountlist=new ArrayList<>();
	@GetMapping("/")
	public void getDetails() {	
			System.out.println(" Total No  of Accounts : "+ accountlist.size());	
	}
	
	@GetMapping("/{id}")
	public Account getDetail(@PathVariable String name)
	{  

		for(Account account : accountlist) {
			System.out.println(account.getOwnerName() + " -- ");
			if(account.getOwnerName().equals(name))
				return account;
		}
				return null;	
		
	}
	
	@PostMapping
	String displayDetails(@RequestBody Account account) {
		
		
		accountService.Save(account);
		System.out.println("Account Details");
		System.out.println("Name : " + account.getOwnerName());
		System.out.println("Amount : " + account.getAmount());
		System.out.println("Date Of Creation : " + account.getDateOfCreation());
		System.out.println("Account Type : " + account.getAccountType());
		System.out.println("Account Status : " + account.getStatus());
		
		return "Account Details Displayed";

	}
	
}