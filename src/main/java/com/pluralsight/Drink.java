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

    public double price(){
        //return 0 until i make the calculations
        flavor = ConsoleHelper.promptForString
                ("What flavor soda would you like?");
        System.out.println("""
             What size would you like?
             ==========================
             1) Small
             2) Medium
             3) Large
             ===========================
            """);
        size = ConsoleHelper.promptForString("Enter your option:");
        switch (size) {
            case "1":
                itemPrice = 2.00;
                break;
            case "2":
                itemPrice = 2.50;
                break;
            case "3":
                itemPrice = 3.00;
                break;
            default:
                System.out.println("Error!");
            }


            System.out.println("Your soda is: " + flavor);
        System.out.printf
                ("The price for this item is: $%.2f", itemPrice);
        System.out.println();

        return itemPrice;
    }
    public Drink(String itemName, double itemPrice, String flavor, String size) {
        super(itemName,itemPrice);
        this.flavor = flavor;
        this.size = size;
    }
    public Drink(){
        super("Drink",0.00);
        this.flavor = flavor;
        this.size = size;
    }
    //adding to string just in case its needed
    @Override
    public String toString() {
        return String.format("%s| $%.2f |%s | %d | %s | %s | %s |",
                itemName, itemPrice, flavor, size);

    }
}