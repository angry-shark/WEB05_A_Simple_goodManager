package model;

public class BankAccount {
    private String customerid;
    private int accountid;

    public BankAccount(String customerid, int accountid) {
        this.customerid = customerid;
        this.accountid = accountid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }
}
