package com.pluralsight;

public class Sandwich extends Items {
    //this will be a child class of Items as it will contain its name and price


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
    public Sandwich(){
        super("Sandwich", 0.00);
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


    public double price(){

        //returning 0 until i do my calculations
        return 0;
    }

    String userInput = ConsoleHelper.promptForString("hi");

    public double sandwichPrice() {
        // make calculation for only the sandwhich price here maybe?
        switch (size) {
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
    public double meatToppingPrice(){
        double basePrice = 0;
        double extraPrice = 0;

        switch (size){
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


    public double cheeseToppingPrice(){
        double basePrice = 0;
        double extraPrice = 0;
        switch (size){
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



}