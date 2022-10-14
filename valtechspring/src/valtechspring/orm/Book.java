package valtechspring.orm;

import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="AllBook")
@DiscriminatorColumn(name="disc")
@DiscriminatorValue("book")
public class Book {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String name;
    private int yearPublished;
    @ManyToMany(targetEntity=Author.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name="author",joinColumns=@JoinColumn(name="book_id",referencedColumnName="id"),
    inverseJoinColumns=@JoinColumn(name="author_id",referencedColumnName="id"))
    private Set<Author> author;
    @ManyToOne(targetEntity=Publisher.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},fetch=FetchType.EAGER)
    private Set<Publisher> publisher;
    
    public Book() {}

    public Book(String name, int yearPublished) {
        super();
        this.name = name;
        this.yearPublished = yearPublished;
    }
    
    public Book(int id, String name, int yearPublished) {
        super();
        this.id = id;
        this.name = name;
        this.yearPublished = yearPublished;
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

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", yearPublished=" + yearPublished + ", author=" + author
                + ", publisher=" + publisher + "]";
    }
    
}

