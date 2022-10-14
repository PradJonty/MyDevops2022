package valtechspring.orm;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String Name;
	private int number;
	
	@ManyToMany(targetEntity = Book.class, cascade = { CascadeType.MERGE,
	          CascadeType.PERSIST }, fetch = FetchType.LAZY)
	  private Set <Book> book;
	
	@OneToOne(targetEntity = MyAddress.class, cascade = { CascadeType.MERGE,
	          CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "author")
	 

	
	private Set <MyAddress> myaddress;
	
	public Author() {
	}
	public Author(int id, String name, int number) {
		super();
		this.id = id;
		Name = name;
		this.number = number;
	}
	public Author(String name, int number) {
		super();
		Name = name;
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", Name=" + Name + ", number=" + number + ", myaddress=" + myaddress + "]";
	}
	
}
