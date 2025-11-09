package com.pluralsight;

public class Sandwich extends Items {
    //this will be a child class of Items as it will contain its name and price


    private String size;
    private String bread;
    private boolean toasted;
    private String toppings; //to do - find a way to have my list of toppings

    //to do - make a menu screen for this class

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
        //to do - add prices in menu screen to assist customer in decision
        //to do - make this function just like the Drinks.price method

        bread = ConsoleHelper.promptForString("What kind of bread would you like");


        String baseSandwich = ConsoleHelper.promptForString("""
                What size sandwich would you like?
                ==================================
                1) small ($5.50)
                2) medium ($7.00)
                3) large ($8.50)
                ==================================
                Enter your option here""");
        //now do if true take them to toppings and allow them to pick meat or cheese
        //if not true then create the sandwich and take them back to the order screen





        //returning 0 until i do my calculations
        return 0;
    }

    public double sandwichPrice() {
        // make calculation for only the sandwhich price here maybe?
        switch (size) {
            case "1":
                return 5.50;
            case "2":
                return  7.00;
            case "3":
                return  8.50;
            default:
                return 0.00;
        }

    }
    public double meatToppingPrice( int extraMeat){
        double basePrice = 0;
        double extraPrice = 0;

        switch (size){
            case "1":
                basePrice = 1.00;
                extraPrice = .50;
                break;
            case "2":
                basePrice = 2.00;
                extraPrice = .60;
                break;
            case "3":
                basePrice = 3.00;
                extraPrice = .90;
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