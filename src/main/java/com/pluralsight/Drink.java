package com.pluralsight;

public class Drink extends Items{
    //will have my drink options
    //to do - determine how I will be adding flavors

    private String flavor;
    private String size;

    public Drink(String itemName, double itemPrice, String flavor, String size) {
        super(itemName, itemPrice);
        this.flavor = flavor;
        this.size = size;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double price(){
        //return 0 until i make the calculations
        return 0;
    }
//adding to string just in case its needed
    @Override
    public String toString() {
        return "Drink{" +
                "flavor='" + flavor + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
