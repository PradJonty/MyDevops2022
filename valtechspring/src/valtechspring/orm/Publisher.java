package valtechspring.orm;

import java.util.Set; 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;


@Entity
public class Publisher {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String address;
    private int phone;
    @OneToMany(targetEntity=Book.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.LAZY,mappedBy="publisher")
    @JoinTable(name="publisher_book",joinColumns=@JoinColumn(name="publisher_id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="Book_id",referencedColumnName="id"))  
    private Set<Book> book;
    
    
    public Publisher(){}


    public Publisher(String name, String address, int phone) {
        super();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    public Publisher(int id, String name, String address, int phone) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    
    public Set<Book> getBook() {
        return book;
    }


    public void setBook(Set<Book> book) {
        this.book = book;
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


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public int getPhone() {
        return phone;
    }


    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Publisher [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", book=" + book
                + "]";
    }
    
    
}