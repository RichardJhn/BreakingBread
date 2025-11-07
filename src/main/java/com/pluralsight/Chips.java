package com.pluralsight;

public class Chips extends Items {
    //chipType will be the brand or flavor they choose
     private String chipType;

    public Chips(String itemName, double itemPrice, String chipType) {
        super(itemName, itemPrice);
        this.chipType = chipType;
    }

    public String getChipType() {
        return chipType;
    }
    public double price(){
        //this will return 0 until i make the calculations
        return 0;
    }
//not sure if i need a to string here but will add just in case
    @Override
    public String toString() {
        return "Chips{" +
                "chipType='" + chipType + '\'' +
                '}';
    }
}
