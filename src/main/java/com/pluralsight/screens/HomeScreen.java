package com.pluralsight.screens;

import com.pluralsight.models.ConsoleHelper;

public class HomeScreen {
    //will be using this class as my home screen
    public void displayHomeScreen() {
        OrderScreen orderScreen = new OrderScreen();
        String choice = "";
        // if the user inputs 0, they will exit the application
        while (!choice.equalsIgnoreCase("0")) {
            System.out.println("""
                    =========Home Screen=======
                    1) New Order
                    0) Exit
                    ===========================
                    """);

            choice = ConsoleHelper.promptForString("Please enter your choice");

            switch (choice) {
                case "1":
                    orderScreen.loadOrderScreen();
                    break;
                case "0":
                    System.out.println("Exiting HomeScreen");
                    return;
                default:
                    System.out.println("Error!");
            }

        }
    }
}
