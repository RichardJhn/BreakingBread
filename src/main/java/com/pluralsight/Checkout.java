package com.pluralsight;
import java.util.Scanner;
public class Checkout {
    Scanner scanner = new Scanner(System.in);
    public void displayCheckout(){

        //make a simple checkout menu for now
        //to do - code the deletion of all options and add a method to save to new file for every new customer

        String choice = "";
        while (!choice.equalsIgnoreCase("0")){
            System.out.println("""
                    ==========Checkout=========
                    1) Confirm
                    0) Cancel
                    """);

            choice = scanner.nextLine();

            switch (choice.toString()){
                case "1":
                    //placeholder for Confirm
                    break;
                case "2":
                    //placeholder for cancel
                    break;
                default:
                    System.out.println("Error!");
            }

        }


    }
}
