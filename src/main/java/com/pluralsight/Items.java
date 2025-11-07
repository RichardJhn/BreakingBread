package com.pluralsight;

public abstract class Items {

    //to do - make this a parent class
    //make all menu items a child of this abbstract class

    protected String itemName;
    protected double itemPrice;

    public Items(String itemName, double itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public abstract double price();

    @Override
    public String toString() {
        return String.format("%s | %.2f", itemName, itemPrice);
    }
}
