package valtechspring.orm;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class MyAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String street;
	private String city;
	private String store;
	private String state;
	private int zipcode;

	

	 @OneToOne(targetEntity = Author.class, cascade = { CascadeType.MERGE,
	            CascadeType.PERSIST }, fetch = FetchType.LAZY)
	 private Author author;


	
	public MyAddress(){}
	
	public MyAddress(int id, String street, String city, String store, String state, int zipcode) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.store = store;
		this.state = state;
		this.zipcode = zipcode;
	}
	public MyAddress( String street, String city, String store, String state, int zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.store = store;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "MyAddress [id=" + id + ", street=" + street + ", city=" + city + ", store=" + store + ", state=" + state
				+ ", zipcode=" + zipcode + "]";
	}
}
