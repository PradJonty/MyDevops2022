package valtechspring.orm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("hbook")
public class HandBook extends Book {
	
private int price;

private int edition;
private int isbn;
public HandBook() {
	super();
	// TODO Auto-generated constructor stub
}
public HandBook(int price,  int edition, int isbn) {
	super();
	this.price = price;

	this.edition = edition;
	this.isbn = isbn;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

public int getEdition() {
	return edition;
}
public void setEdition(int edition) {
	this.edition = edition;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
@Override
public String toString() {
	return "HandBook [price=" + price + " edition=" + edition + ", isbn=" + isbn
			+ ", getId()=" + getId() + ", getName()=" + getName() + ", toString()=" + super.toString() + "]";
}


}
