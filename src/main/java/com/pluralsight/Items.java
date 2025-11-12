package com.pluralsight;

public abstract class Items {

    //to do - make this a parent class
    //make all menu items a child of this abstract class

    public String  itemName;

    public Items(String itemName){
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    // Abstract method that forces subclasses to define how their price is calculated
    public abstract double getPrice();

    @Override
    public String toString() {
        return String.format("%s | %.2f", itemName);
    }
}
