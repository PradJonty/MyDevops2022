package com.valtech.account.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="customers")

public class Customer {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String number;
	private String address;
	private String customerType;
	private int pincode;
	private LocalDate birthDate;
	@ManyToMany(targetEntity = Account.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy ="customers")
	private Set<Account> account;
	public Set<Account> getAccount() {
		return account;
	}
	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Customer(int id, String name, String email, String number, String address, String customerType, int pincode,
			LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
		this.address = address;
		this.customerType = customerType;
		this.pincode = pincode;
		this.birthDate = birthDate;
	}
	public Customer() {
	
	}
	public Customer(String name, String email, String number, String address, String customerType, int pincode,
			LocalDate birthDate) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.address = address;
		this.customerType = customerType;
		this.pincode = pincode;
		this.birthDate = birthDate;
	}
	
}
