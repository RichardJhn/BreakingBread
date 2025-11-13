package com.Sellables;

import com.pluralsight.Items;
import com.pluralsight.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Items {
    //this will be a child class of Items as it will contain its name and price

    private String size;
    private String bread;
    private boolean toasted;
    private List<Topping> toppings; //to do - find a way to have my list of toppings
    private double toppingsTotal;

    //to do - make a menu screen for this class

    public Sandwich(String itemName, String size, String bread, boolean toasted) {
        super(itemName);
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    public Sandwich() {
        super("Sandwich");
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

    public List<Topping> getToppings(){
        return toppings;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }


    public void setToppingsTotal(double toppingsTotal) {
        this.toppingsTotal = toppingsTotal;
    }
    //to do - add different prices for different sizes

    public double getPrice() {

        //to do - add prices in menu screen to assist customer in decision
        //to do - make this function just like the Drinks.price method
        if(size == null){
            System.out.println("checking for null");
            return 0;
        }


        double baseSandwich = switch (size) {
            case "Small" -> 5.50;
            case "Medium" -> 7.00;
            case "Large" -> 8.50;

            default -> {
                System.out.println("This is not a size option");
                yield 0.00;
            }
            };
        double toppingsTotal = 0.00;
            for(Topping topping : toppings){
                toppingsTotal += topping.getPrice(size);
            }
            double total = baseSandwich + toppingsTotal;
            return total;


    }

}