package com.pluralsight;
import java.util.Scanner;
public class Drink extends Items{
    //will have my drink options
    //to do - determine how I will be adding flavors
    //do not touch this class
    private String flavor;
    private String size;

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public  double getPrice(){
        double baseDrink = switch (size) {
            case "Small" -> 2.00;
            case "Medium" -> 2.50;
            case "Large" -> 3.00;
            default -> {
                System.out.println("Not a size option!");
                yield 0.00;
            }

            };


        return baseDrink;
    }

    public Drink(String itemName, String flavor, String size) {
        super(itemName);
        this.flavor = flavor;
        this.size = size;
    }
    public Drink(){
        super("Drink");
        this.flavor = flavor;
        this.size = size;
    }
    //adding to string just in case its needed
    @Override
    public String toString() {
        return String.format("%s| $%.2f |%s | %d | %s | %s | %s |",
                itemName, flavor, size);

    }

}