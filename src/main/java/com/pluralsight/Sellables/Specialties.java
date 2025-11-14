package com.pluralsight.Sellables;

public class Specialties extends Sandwich{
    //this class has the pre-set specialties
    public Sandwich theBreakingOfBreads() {
        Sandwich sandwich = new Sandwich();
        sandwich.setSize("Large");
        sandwich.setBread("Wheat");
        sandwich.setToasted(true);

        Topping topping = new Topping("Steak","Meat",10);
        Topping topping2 = new Topping("American","Cheese",12);

        sandwich.addTopping(topping);
        sandwich.addTopping(topping2);

        return sandwich;
    }

    public Sandwich theFullBread(){
        Sandwich sandwich = new Sandwich();
        sandwich.setSize("Large");
        sandwich.setBread("White");
        sandwich.setToasted(true);

        Topping topping = new Topping("Salami","Meat",3);
        Topping topping1 = new Topping("Mozzarella","Cheese", 2);
        Topping topping2 = new Topping("Steak", "Meat", 2);

        sandwich.addTopping(topping);
        sandwich.addTopping(topping1);
        sandwich.addTopping(topping2);

        return sandwich;
    }

    public Sandwich theRandom(){
        Sandwich sandwich = new Sandwich();
        sandwich.setSize("Small");
        sandwich.setBread("Wheat");
        sandwich.setToasted(false);

        Topping topping = new Topping("American", "Cheese",1);

        sandwich.addTopping(topping);
        return sandwich;
    }

}
