package com.valtech.account.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;






@Entity
@Table(name="accounts")
public class Account {
	
	public static final String SAVINGS = "SB";
	public static final String CURRENT = "CA";
	



   @Id@GeneratedValue(strategy=GenerationType.IDENTITY)
    private  long id;
    private String accountType;
    private double balance;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;
    private boolean active;
    @ManyToMany(targetEntity = Customer.class, cascade = { CascadeType.MERGE,
            CascadeType.PERSIST })
    @JoinTable(name="customer_account",joinColumns = @JoinColumn(name="account_id",referencedColumnName="id"),
    inverseJoinColumns = @JoinColumn(name="customer_id",referencedColumnName="id"))
    
    private Set<Customer> customers;
    
    
    public Account() {}
    
    
    public Account(long id, String accountType, double balance, LocalDate creationDate, LocalDate lastUpdateDate,
            boolean active) {
        super();
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.active = active;
    }




    public Account(String accountType, double balance) {
        
        this.accountType = accountType;
        this.balance = balance;
        this.creationDate = LocalDate.now();
        this.lastUpdateDate =  LocalDate.now();
        this.active = false;
    }

  public Set<Customer> getCustomers() {
	return customers;
}
public void setCustomers(Set<Customer> customers) {
	this.customers = customers;
}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }
    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
