package com.pluralsight;

public class Topping {

    //moved toppings to its own class
    private String name;
    private String toppingType;
    private int extra;
    //constructor with toppings
    public Topping(String name, String toppingType, int extra) {
        this.name = name;
        this.toppingType = toppingType;
        this.extra = extra;
    }
    //this is the constructor for no extra toppings
    public Topping(String name, String toppingType){
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

    public String meatToppingChoice(){

        return "";
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

    public double getPrice(String size) {
        //deturmine the price, using already existing knowledge of type and extra, and passed in value of size...
        if (toppingType == null) return 0.00;

        if (toppingType.equals("Steak") ||
                toppingType.equalsIgnoreCase("Pork") ||
                toppingType.equalsIgnoreCase("Ham") ||
                toppingType.equalsIgnoreCase("Turkey") ||
                toppingType.equalsIgnoreCase("Salami")) {

            return meatToppingPrice(size, extra);
            //place holder

        }
        if(toppingType.equalsIgnoreCase("American") ||
                toppingType.equalsIgnoreCase("Bleu") ||
                toppingType.equalsIgnoreCase("Three-Cheese") ||
                toppingType.equalsIgnoreCase("Mozzarella")) {
        return cheeseToppingPrice(size, extra);
         }
         return 0.0;
    }


}

