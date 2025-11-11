package com.pluralsight;
import java.util.ArrayList;
import java.util.List;
public class Toppings {

    //moved toppings to its own class
    private String name;
    private String toppingType;
    private int extra;
    //constructor with toppings
    public Toppings(String name, String toppingType, int extra) {
        this.name = name;
        this.toppingType = toppingType;
        this.extra = extra;
    }
    //this is the constructor for no extra toppings
    public Toppings(String name, String toppingType){
        this(name, toppingType, 0);
    }

    //paid toppings
    public static final String [] meat = {"Steak", "Pork", "Ham", "Turkey", "Salami"};
    public static final String [] cheese = {"American", "Bleu", "Cheese","Mozzarella"};

    //toppings that come with the sandwich
    public static final String [] regularToppings = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeno", "Cucumber", "Pickles","Guacamole", "Mushrooms"};
    public static final String [] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};

    //maybe add the types of bread in here too?
    public static final String [] bread = {"Wheat", "White", "Rye", "French", "Whole Grain"};
    public static final String [] sides = {"sauce", "au jus"};

    public String getName() {
        return name;
    }

    public String getToppingType() {
        return toppingType;
    }

    public int getExtra() {
        return extra;
    }


    public double meatToppingPrice(String size, int extraMeat){
        double basePrice = 0;
        double extraPrice = 0;

        switch (size){
            case "1":
                basePrice = 1.00;
                extraPrice = .50;
                break;
            case "2":
                basePrice = 2.00;
                extraPrice = 1.00;
                break;
            case "3":
                basePrice = 3.00;
                extraPrice = 1.50;
                break;
            default:
                return 0.00;
        }
        //do the base sandwich then add it by the extra price times the amount the customer will buy
        return basePrice + (extraPrice * extraMeat);
    }

    public double cheeseToppingPrice(String size, int extraCheese){
        double basePrice = 0;
        double extraPrice = 0;

        switch (size){
            case "1":
                basePrice = .75;
                extraPrice = .30;
                break;
            case "2":
                basePrice = 1.50;
                extraPrice = .60;
                break;
            case "3":
                basePrice = 2.25;
                extraPrice = .90;
                break;
            default:
                return 0.00;
        }
        //the same as above
        return basePrice + (extraPrice * extraCheese);
    }

}

