package valtechspring.orm;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
@Entity

public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)   //use sequence for oracle
	private int id;
	private String make;
	private String model;
	private String color;
    private float price;
    private int yearManufactured;
    
    @Version
    private int version;
    
    @Embedded
    private CarDetails carDetails;



	public Car(){}    // mandatory to create a parameterless constructor
    
    
	public Car(int id, String make, String model, String color, float price, int yearManufactured, CarDetails carDetails) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.color = color;
		this.price = price;
		this.yearManufactured = yearManufactured;
		this.carDetails = carDetails;// parameterized constructor with id
	}


	public Car(String make, String model, String color, float price, int yearManufactured,CarDetails carDetails) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.price = price;
		this.yearManufactured = yearManufactured;
		this.carDetails = carDetails;
		// // parameterized constructor without id
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", color=" + color + ", price=" + price
				+ ", yearManufactured=" + yearManufactured + ", version=" + version + ", carDetails=" + carDetails
				+ "]";
	}


	public CarDetails getCarDetails() {
		return carDetails;
	}


	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getYearManufactured() {
		return yearManufactured;
	}


	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}

public int getVersion() {
	return version;
}
public void setVersion(int version) {
	this.version = version;
}
	
}
