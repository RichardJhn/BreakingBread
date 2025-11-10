package com.pluralsight;

public class HomeScreen {
    //will be using this class as my home screen
    //to do- make Order menu then move it here to make it neat

    //might blend this in with order screen to create a UserInterface class?

    public void displayHomeScreen() {
        OrderScreen orderScreen = new OrderScreen();
        String choice = "";

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
