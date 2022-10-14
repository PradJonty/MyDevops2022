package valtechspring.orm;

import java.io.Serializable;

public class BankAccountId implements Serializable{
    
    private int AccountNo;
    private String AccountType;
    



   public BankAccountId() {}
    public BankAccountId(int AccountNo, String AccountType) {
        super();
        this.AccountNo = AccountNo;
        this.AccountType = AccountType;
    }
    
    public int getAccountNo() {
        return AccountNo;
    }
    public void setAccountNo(int AccountNo) {
        this.AccountNo = AccountNo;
    }
    public String getAccountType() {
        return AccountType;
    }
    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AccountNo;
		result = prime * result + ((AccountType == null) ? 0 : AccountType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccountId other = (BankAccountId) obj;
		if (AccountNo != other.AccountNo)
			return false;
		if (AccountType == null) {
			if (other.AccountType != null)
				return false;
		} else if (!AccountType.equals(other.AccountType))
			return false;
		return true;
	}
    
}

