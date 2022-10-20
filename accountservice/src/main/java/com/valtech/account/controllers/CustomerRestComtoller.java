package com.valtech.account.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.account.entity.Customer;
import com.valtech.account.service.CustomerService;

@RestController
public class CustomerRestComtoller {
@Autowired
private CustomerService customerService;


@PutMapping("/api/customers/{id}")
public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
    customer.setId(id);
    return customerService.updateAccount(customer);
}



@PostMapping("/api/customers")
public Customer createCustomer(@RequestBody Customer customer) {
    return customerService.createAccount(customer);
}



@GetMapping("/api/customers/{id}")
public Customer getCustomer(@PathVariable("id") int id) {
    return customerService.getCustomer(id);
}



@GetMapping("/api/customers")
public List<Customer> getCustomers() {
    return customerService.getAllCustomers();
}



}



//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.valtech.account.entity.Account;
//import com.valtech.account.service.AccountService;
//
//@RestController
//public class AccountRestContoller {
//	
//@Autowired
//private AccountService accountService;
//	public Account createCurrentAccount() {
//		return null;
//		
//	}
//	@PostMapping("/api/accounts/SB")
//	public Account createSavingsAccount(@RequestParam("balance") double balance) {
//		return accountService.createSavingsAccount(balance);
//		
//		
//	}
//
//	@PostMapping("/api/accounts/CA")
//	public Account createCurrentAccount(@RequestParam("balance") double balance) {
//		return accountService.createCurrentAccount(balance);
//}
//	
//	
//}