package valtechspring.orm;

import valtechspring.orm.*;


import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="alltxs")
@DiscriminatorColumn(name="disc")
@DiscriminatorValue("tx")
public class Tx {



   
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private float amount;
  //FetchType.Eager    ->when tx is loaded account  also shoul be loaded
    //FetchType.Lazy ->when Tx is loaded account will not be loaded
    @ManyToOne(targetEntity=Account.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.EAGER)
    @JoinColumn(name="account_id",referencedColumnName="id")
    private Account account;
    
    
    public Tx() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Tx(float amount) {
        super();
        this.amount = amount;
    }
    
    
    public Account getaccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}




	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
	@Override
	public String toString() {
		return "Tx [id=" + id + ", amount=" + amount + ", getId()=" + getId() + ", getAmount()=" + getAmount() + "]";
	}
  
    
}