package com.pluralsight.screens;
import com.pluralsight.Sellables.*;
import com.pluralsight.models.ConsoleHelper;
import com.pluralsight.models.Order;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckoutScreen {
    private Order order;

    public CheckoutScreen(Order order){
        this.order = order;
    }

    public void displayCheckout(){

        String choice = "";
        while (!choice.equalsIgnoreCase("0")){
            System.out.println("""
                    ==========Checkout=========
                    1) Confirm
                    0) Cancel
                    ============================
                    """);

            choice = ConsoleHelper.promptForString("Please Make your choice");

            switch (choice.toString()){
                case "1" -> {
                    //confirms the order and deletes all user inputs to make a new order
                    //then takes user back to order screen for a new order
                    confirmOrder();
                    return;
                }
                    //placeholder for Confirm
                case "0" -> {
                    //cancels the order and deletes user inputs for order
                    cancelOrder();
                }
                default ->  System.out.println("Error!");
            }

        }

    }

    private void confirmOrder() {
        //Building receipts
        //append adds to the end
        StringBuilder receipt = new StringBuilder();
        receipt.append("=======Breaking Bread Receipt========\n");
        receipt.append(order.getOrderID()).append("\n");
        receipt.append("Date :").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n").append("=====================================\n");

        double total = 0;
        for (Items item : order.getItems()) {
            //if the child class is a sandwich it will do this -
            if (item instanceof Sandwich sandwich) {
                receipt.append("Sandwich " + ":\n");
                receipt.append("Bread : ").append(sandwich.getBread()).append("\n");
                receipt.append("Toasted : ").append(sandwich.isToasted() ? "Yes" : "No").append("\n");
                receipt.append("Size : ").append(sandwich.getSize()).append("\n");
                receipt.append("Toppings :\n");
                for (Topping topping : sandwich.getToppings()) {
                    receipt.append("    - ").append(topping.getName());
                    if (topping.getExtra() > 0) {
                        receipt.append(" (extra : ").append(topping.getExtra()).append(")");
                    }
                    receipt.append("\n");
                }
                receipt.append(String.format("  Subtotal: $%.2f\n\n", sandwich.getPrice()));
                total += sandwich.getPrice();
            }
            //if the child class is a drink it will do this -
            if (item instanceof Drink drink) {
                receipt.append("Drink:\n");
                receipt.append("  Flavor: ").append(drink.getFlavor()).append("\n");
                receipt.append("  Size: ").append(drink.getSize()).append("\n");
                receipt.append(String.format("  Price: $%.2f\n\n", drink.getPrice()));
                total += drink.getPrice();
            }
            //if the child class is a chip it will do this
            if (item instanceof Chips chips) {
                receipt.append("Chips:\n");
                receipt.append("  Type: ").append(chips.getChipType()).append("\n");
                receipt.append(String.format("  Price: $%.2f\n\n", chips.getPrice()));
                total += chips.getPrice();
            }
        }
        receipt.append(String.format("\n Total : $%.2f\n", order.totalPrice()));
        receipt.append("======================================\n");
        receipt.append("Thank you for your order!\n");
        System.out.println(receipt);

        //if the folder Receipts doesn't exist it will create a new folder and name it Receipts as folderPath is named
        //nio  is new input/output -
        try{
            java.nio.file.Path folderPath = java.nio.file.Paths.get("Receipts");
            if(!java.nio.file.Files.exists((folderPath))){
                java.nio.file.Files.createDirectory((folderPath));
            }
            //this is the structure as what the receipt will be saved as
            String filename = "Receipts/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyMMdd_HHmmss")) + ".txt";
            java.nio.file.Files.writeString(java.nio.file.Paths.get(filename), receipt.toString());
            System.out.println("Order saved to : " + filename );

        }catch (Exception e){
            System.out.println("Error saving to file!");
        }
        //this makes the order empty and deleted everything
        order = null;

    }
    public void cancelOrder(){
        //this makes order empty and takes them back to home menu
        order = null;
        System.out.println("Order has been canceled. Returning to the Order Screen");
    }
}