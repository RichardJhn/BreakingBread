package com.pluralsight;

import java.util.Scanner;

import java.util.Scanner;
public class Sandwich extends Items {
    //this will be a child class of Items as it will contain its name and price
    Scanner scanner = new Scanner(System.in);

    private String size;
    private String bread;
    private boolean toasted;
    private String toppings; //to do - find a way to have my list of toppings

    public Sandwich(String itemName, double itemPrice, String size, String bread, boolean toasted, String toppings) {
        super(itemName, itemPrice);
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = toppings;
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

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }
    //to do - add different prices for different sizes

    String userInput = scanner.nextLine().trim();

    public double price(){

        //returning 0 until i do my calculations
        return 0;
    }
    
    public double sandwichPrice() {
        // make calculation for only the sandwhich price here maybe?

        switch (userInput) {
            case "1":
                itemPrice = 5.50;
                break;
            case "2":
                itemPrice = 7.00;
                break;
            case "3":
                itemPrice = 8.50;
                break;
            default:
                System.out.println("Error");
        }
    return itemPrice;

    }
    public double meatTopping(){
        switch (userInput){
            case "1":
                itemPrice = 1.00;
                break;
            case "2":
                itemPrice = 2.00;
                break;
            case "3":
                itemPrice = 3.00;
                break;
            default:
                System.out.println("Error");
        }
        return itemPrice;
    }

    public double extraMeat(){
        //adding extra toppings
        //to do - should i allow them to have more than 1 extra topping and keep adding the price?
        switch (userInput){
            case "1":
                itemPrice += .50;
                break;
            case "2":
                itemPrice += 1.00;
                break;
            case "3":
                itemPrice += 1.50;
                break;
            default:
                System.out.println("error");
        }
        return itemPrice;
    }

    public double cheese(){
        switch (userInput){
            case "1":
                itemPrice = .75;
                break;
            case "2":
                itemPrice = 1.50;
                break;
            case "3":
                itemPrice = 2.25;
                break;
            default:
                System.out.println("Error!");
        }
        return itemPrice;
    }

    public double extraCheese(){
        switch (userInput){
            case "1":
                itemPrice += .30;
                break;
            case "2":
                itemPrice += .60;
                break;
            case "3":
                itemPrice += .90;
                break;
            default:
                System.out.println("Error!");
        }
        return itemPrice;
    }


}
