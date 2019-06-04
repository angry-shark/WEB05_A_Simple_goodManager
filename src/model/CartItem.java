package model;

public class CartItem{
    public String itemName;
    public int price;
    public int itemCount;
    public int itemid;

    public CartItem(String itemName, int price, int itemCount, int itemid) {
        this.itemName = itemName;
        this.price = price;
        this.itemCount = itemCount;
        this.itemid = itemid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
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

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
