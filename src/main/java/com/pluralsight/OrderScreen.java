package com.pluralsight;
import java.util.Scanner;
public class OrderScreen {
    Scanner scanner = new Scanner(System.in);
    public void loadOrderScreen(){
        HomeScreen homeScreen = new HomeScreen();

        //to do - make code less cryptic if possible

        String choice = "";
        while (!choice.equalsIgnoreCase("0")){
            System.out.println("""
                    ========Order Menu ========
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order
                    ============================
                    Please Make your choice
                    ============================
                    """);

            choice = scanner.nextLine().trim();
            //to do - make add sandwhich and plan how i will be calculating toppings

            switch(choice.toString()){
                case "1":
                case "2":
                case "3":
                case "4":
                case "0":
                    System.out.println("Cancelling order and returning to Home Menu");
                    homeScreen.displayHomeScreen();
                default:
                    System.out.println("Error!");
            }

        }

    }
}
