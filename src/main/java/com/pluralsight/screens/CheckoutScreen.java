package com.pluralsight.screens;

import com.Sellables.Sandwich;
import com.pluralsight.ConsoleHelper;
import com.pluralsight.Topping;
import com.pluralsight.models.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckoutScreen {
    private Order order;
    private Sandwich sandwich;
    public CheckoutScreen(Order order){
        this.order = order;
    }

    public void displayCheckout(){

        //make a simple checkoutScreen menu for now
        //to do - code the deletion of all options and add a method to save to new file for every new customer

        String choice = "";
        while (!choice.equalsIgnoreCase("0")){
            System.out.println("""
                    ==========Checkout=========
                    1) Confirm
                    0) Cancel
                    ============================
                    """);

            //to do - determine whether to take user back to home screen or order screen after confirm and cancel

            choice = ConsoleHelper.promptForString("Please Make your choice");

            switch (choice.toString()){
                case "1" -> confirmOrder();
                    //placeholder for Confirm
                case "0" -> {
                    System.out.println("Cancelling Order");
                    //placeholder for cancel
                    return;
                }
                default ->  System.out.println("Error!");
            }

        }

    }

    private void confirmOrder(){
        //Building receipts
        StringBuilder receipt = new StringBuilder();
        receipt.append("=======Breaking Bread Receipt========\n");
        receipt.append("Date :").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n");
        receipt.append("Bread : ").append(sandwich.getBread()).append("\n");
        //receipt.append("Toasted :")
        receipt.append("Toppings: \n");
        for (Topping topping : sandwich.getToppings()){
            receipt.append("-").append(topping.getToppingType())
                    .append("Extras:").append(topping.getExtra()).append("\n");
        }
        receipt.append(String.format("Total: $%.2f", sandwich.getPrice()));


        receipt.append(String.format("\nTOTAL: $%.2f\n", order.totalPrice()));
        receipt.append("======================================\n");
        receipt.append("Thank you for your order!\n");

        System.out.println(receipt);
    }
}