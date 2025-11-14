package com.pluralsight.Sellables;

public class Specialties extends Sandwich{
    // I WILL GET THIS DONE!!!!

    public Sandwich theBreakingOfBreads() {
        Sandwich sandwich = new Sandwich();
        sandwich.setSize("Large");
        sandwich.setBread("Wheat");
        sandwich.setToasted(true);
        
        Topping topping = new Topping("Steak","Meat",10);
        Topping topping2 = new Topping("American","Cheese",12);

        return sandwich;
    }






}
