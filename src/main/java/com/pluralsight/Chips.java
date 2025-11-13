package com.pluralsight;
public class Chips extends Items {
    //chipType will be the brand or flavor they choose
     public String chipType;

    public Chips(String itemName, String chipType) {
        super(itemName);
        this.chipType = chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }
//made public Chips so i wouldnt have to create a new chip
    public Chips(){
        super("Chips");
        this.chipType = chipType;
    }

    public String getChipType() {
        return chipType;
    }
    public double getPrice(){
        //this will return 0 until i make the calculations
        return 1.50;
    }
//not sure if i need a to-string here but will add just in case

}
