package valtechspring.orm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bbook")
public class Blog extends Book{
	private String url;
	private int noOfTimes;
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(String url, int noOfTimes) {
		super();
		this.url = url;
		this.noOfTimes = noOfTimes;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getNoOfTimes() {
		return noOfTimes;
	}
	public void setNoOfTimes(int noOfTimes) {
		this.noOfTimes = noOfTimes;
	}
	@Override
	public String toString() {
		return "Blog [url=" + url + ", noOfTimes=" + noOfTimes + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getYearPublished()=" + getYearPublished() + "]";
	}
	

}


//public Article() {
//	super();
//	// TODO Auto-generated constructor stub
//}
//
//public Article(String url) {
//	super();
//	this.url = url;
//}
//
//public String getUrl() {
//	return url;
//}
//
//public void setUrl(String url) {
//	this.url = url;
//}
//
