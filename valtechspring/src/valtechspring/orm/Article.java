package valtechspring.orm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("abook")
public class Article  extends Book{

	  private String url;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Article [url=" + url + ", getId()=" + getId() + ", getName()=" + getName() + ", getYearPublished()="
				+ getYearPublished() + "]";
	}



}

//    public TellerTx() {
//        
//    	// TODO Auto-generated constructor stub
//    }
//    public TellerTx(float amount,String teller, String branch) {
//        super(amount);
//        this.teller = teller;
//        this.branch = branch;
//    }
//    public String getTeller() {
//        return teller;
//    }
//    public void setTeller(String teller) {
//        this.teller = teller;
//    }
//    public String getBranch() {
//        return branch;
//    }
//    public void setBranch(String branch) {
//        this.branch = branch;
//    }










