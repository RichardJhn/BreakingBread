package com.pluralsight.screens;

import com.Sellables.Sandwich;
import com.pluralsight.*;
import com.pluralsight.models.Order;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckoutScreen {
    private Order order;

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

    private void confirmOrder() {
        //Building receipts
        StringBuilder receipt = new StringBuilder();
        receipt.append("=======Breaking Bread Receipt========\n");
        receipt.append("Date :").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n");
        //receipt.append("Toasted :")
        double total = 0;
        for (Items item : order.getItems()) {
            if (item instanceof Sandwich sandwich) {
                receipt.append("Sandwich :\n");
                receipt.append("Bread : ").append(sandwich.getBread()).append("\n");
                receipt.append("Toasted : ").append(sandwich.isToasted() ? "Yes" : "No").append("\n");
                receipt.append("Size : ").append(sandwich.getSize()).append("\n");
                receipt.append("Toppings :\n");
                for (Topping topping : sandwich.getToppings()) {
                    receipt.append("    - ").append(topping.getToppingType());
                    if (topping.getExtra() > 0) {
                        receipt.append(" (extra : ").append(topping.getExtra()).append(")");
                    }
                    receipt.append("\n");
                }
                receipt.append(String.format("  Subtotal: $%.2f\n\n", sandwich.getPrice()));
                total += sandwich.getPrice();
            }

            if (item instanceof Drink drink) {
                receipt.append("Drink:\n");
                receipt.append("  Flavor: ").append(drink.getFlavor()).append("\n");
                receipt.append("  Size: ").append(drink.getSize()).append("\n");
                receipt.append(String.format("  Price: $%.2f\n\n", drink.getPrice()));
                total += drink.getPrice();
            }

            if (item instanceof Chips chips) {
                receipt.append("Chips:\n");
                receipt.append("  Type: ").append(chips.getChipType()).append("\n");
                receipt.append(String.format("  Price: $%.2f\n\n", chips.getPrice()));
                total += chips.getPrice();
//        receipt.append("Toppings: \n");
//        for (Topping topping : sandwich.getToppings()){
//            receipt.append("-").append(topping.getToppingType())
//                    .append("Extras:").append(topping.getExtra()).append("\n");
//        }
//        receipt.append(String.format("Total: $%.2f", sandwich.getPrice()));
//
//



            }
        }
        receipt.append(String.format("\n Total : $%.2f\n", order.totalPrice()));
        receipt.append("======================================\n");
        receipt.append("Thank you for your order!\n");

        System.out.println(receipt);

        try{

            java.nio.file.Path folderPath = java.nio.file.Paths.get("Receipts");
            if(!java.nio.file.Files.exists((folderPath))){
                java.nio.file.Files.createDirectory((folderPath));
            }

            String filename = "Receipts/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyMMdd_HHmmss")) + ".txt";
            java.nio.file.Files.writeString(java.nio.file.Paths.get(filename), receipt.toString());
            System.out.println("Order saved to : " + filename );

        }catch (Exception e){
            System.out.println("Error saving to file!");
        }


    }
}