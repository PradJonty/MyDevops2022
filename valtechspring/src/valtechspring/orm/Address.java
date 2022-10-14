package valtechspring.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity

public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	
	private int id;
	private String street;
	private String city;
	private String store;
	private String state;
	private int zipcode;
	@OneToOne(targetEntity=Address.class)
	@JoinColumn(name="customer_id",referencedColumnName="id") //name is fk on child table, recol is pk of master table
	private Customer customer;
public Address() {}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
    
    
    @Override
public String toString() {
	return "Address [id=" + id + ", street=" + street + ", city=" + city + ", store=" + store + ", state=" + state
			+ ", zipcode=" + zipcode + "]";
}
	public Address(String street, String city, String state, int zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
