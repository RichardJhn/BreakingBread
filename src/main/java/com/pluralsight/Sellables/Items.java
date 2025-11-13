package com.pluralsight.Sellables;

public abstract class Items {
    //makes all menu items a child of this abstract class

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

}
