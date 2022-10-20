package com.valtech.account.service;

import java.util.List;

import com.valtech.account.entity.Customer;

public interface CustomerService {

	//import java.util.List;
	//
	//import org.springframework.beans.factory.annotation.Autowired;
	//import org.springframework.stereotype.Service;
	//
	//import com.valtech.account.entity.Account;
	//import com.valtech.account.repository.AccountRepository;
	//
	//@Service
	//public class AccountServiceImpl implements AccountService {
	//@Autowired
	//private AccountRepository accountRepository;
	//
	//
	Customer createAccount(Customer cus);

	Customer updateAccount(Customer cus);

	Customer getCustomer(long id);

	List<Customer> getAllCustomers();

}