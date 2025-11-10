package com.pluralsight;
public class Chips extends Items {
    //chipType will be the brand or flavor they choose
     private String chipType;

    public Chips(String itemName, double itemPrice, String chipType) {
        super(itemName, itemPrice);
        this.chipType = chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }

    public Chips(){
        super("Chips",0.00);
        this.chipType = chipType;
    }

    public String getChipType() {
        return chipType;
    }
    public double price(){
        //this will return 0 until i make the calculations
        itemPrice = 1.50;
        return itemPrice;
    }
//not sure if i need a to string here but will add just in case

}
