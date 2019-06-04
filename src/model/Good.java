package model;

public class Good {
    private int price;
    private int itemid;
    private String itemName;

    public Good(int price, int itemid, String itemName) {
        this.price = price;
        this.itemid = itemid;
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
}
