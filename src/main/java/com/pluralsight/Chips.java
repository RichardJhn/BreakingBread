package com.pluralsight;

import java.util.Scanner;

import java.util.Scanner;
public class Chips extends Items {
    //chipType will be the brand or flavor they choose
     private String chipType;
     Scanner scanner = new Scanner(System.in);
     String userInput = scanner.nextLine().trim();


    public Chips(String itemName, double itemPrice, String chipType) {
        super(itemName, itemPrice);
        this.chipType = chipType;
    }

    public String getChipType() {
        return chipType;
    }
    public double price(){
        //this will return 0 until i make the calculations
        System.out.print("What kind of chips would you like: ");
        chipType = userInput;
        itemPrice = 1.50;
       return itemPrice;
    }
//not sure if i need a to string here but will add just in case
    @Override
    public String toString() {
        return "Chips{" +
                "chipType='" + chipType + '\'' +
                '}';
    }
}
