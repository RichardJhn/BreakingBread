package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Items {
    //this will be a child class of Items as it will contain its name and price

    private String size;
    private String bread;
    private boolean toasted;
    private List<String> toppings; //to do - find a way to have my list of toppings
    private double toppingsTotal;

    //to do - make a menu screen for this class

    public Sandwich(String itemName, double itemPrice, String size, String bread, boolean toasted, String toppings) {
        super(itemName, itemPrice);
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    public Sandwich() {
        super("Sandwich", 0.00);
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public List<String> getToppings(){
        return toppings;
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public double getToppingsTotal() {
        return toppingsTotal;
    }

    public void setToppingsTotal(double toppingsTotal) {
        this.toppingsTotal = toppingsTotal;
    }
    //to do - add different prices for different sizes

    public double price() {
        //to do - add prices in menu screen to assist customer in decision
        //to do - make this function just like the Drinks.price method

        double totalPrice = sandwichPrice();

        //now do if true take them to toppings and allow them to pick meat or cheese
        //if not true then create the sandwich and take them back to the order screen

        return totalPrice;
    }

    public double sandwichPrice() {
        if(size == null){
            System.out.println("checking for null");
            return 0;
        }

        double baseSandwich = 0.00;
        double toppingsTotal = 0.00;

        switch (size) {
            case "1":
                baseSandwich = 5.50;
                break;
            case "2":
                baseSandwich = 7.00;
                break;
            case "3":
                baseSandwich = 8.50;
                break;
            default:
                System.out.println("This is not a size option");
                return 0.00;
        }
        return baseSandwich;
    }


}