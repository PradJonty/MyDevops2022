package valtechspring.orm;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
//@IdClass(BankAccountId.class)
public class BankAccount {
    @Id
    private int accno;
    @Id
    private String acctype;
    private float balance;
    private Date openingDate;
    private boolean active;

public BankAccount() {
        super();
        // TODO Auto-generated constructor stub
    }
public BankAccount(int accno, String acctype, float balance, Date openingDate, boolean active) {
        super();
        this.accno = accno;
        this.acctype = acctype;
        this.balance = balance;
        this.openingDate = openingDate;
        this.active = active;
    }

 public int getAccno() {
        return accno;
    }

public void setAccno(int accno) {
        this.accno = accno;
    }

 public String getAcctype() {
        return acctype;
    }

 public void setAcctype(String acctype) {
     this.acctype = acctype;
 }

public float getBalance() {
     return balance;
 }


public void setBalance(float balance) {
     this.balance = balance;
 }

public Date getOpeningDate() {
     return openingDate;
 }


public void setOpeningDate(Date openingDate) {
     this.openingDate = openingDate;
 }

public boolean isActive() {
     return active;
 }
public void setActive(boolean active) {
     this.active = active;
 }
@Override
public String toString() {
 return "BankAccount [accno=" + accno + ", acctype=" + acctype + ", balance=" + balance + ", openingDate="
         + openingDate + ", active=" + active + "]";
}





}