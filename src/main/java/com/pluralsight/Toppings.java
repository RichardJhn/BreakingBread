package com.pluralsight;

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

    public String getName() {
        return name;
    }

    public String getToppingType() {
        return toppingType;
    }

    public int getExtra() {
        return extra;
    }

}
