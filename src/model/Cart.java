package model;

public class Cart {
    private int itemid;
    private String customerid;
    private int itemcount;


    public Cart(int itemid, String customerid, int itemcount) {
        this.itemid = itemid;
        this.customerid = customerid;
        this.itemcount = itemcount;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public int getItemcount() {
        return itemcount;
    }

    public void setItemcount(int itemcount) {
        this.itemcount = itemcount;
    }

}
