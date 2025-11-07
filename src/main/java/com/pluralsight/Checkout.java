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
                    ============================
                    Please make your choice
                    ============================
                    """);
            //to do - determine whether to take user back to home screen or order screen after confirm and cancel

            choice = scanner.nextLine();

            switch (choice.toString()){
                case "1":
                    //placeholder for Confirm
                    break;
                case "0":
                    System.out.println("Cancelling Order");
                    //placeholder for cancel
                    return;
                default:
                    System.out.println("Error!");
            }

        }


    }
}
