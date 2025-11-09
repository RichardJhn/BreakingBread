package com.pluralsight;
import java.util.ArrayList;
public class OrderScreen {

    public void loadOrderScreen(){
        HomeScreen homeScreen = new HomeScreen();
        Checkout checkout = new Checkout();
        ArrayList<Items> items = new ArrayList<>();
        Drink drink = new Drink();
        Chips chips = new Chips();
        Sandwich sandwich = new Sandwich();

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
                    """);

            choice = ConsoleHelper.promptForString("Please Make your choice");
            //to do - make add sandwhich and plan how i will be calculating toppings

            switch(choice.toString()){
                case "1":
                    sandwich.price();
                    break;
                case "2":
                    drink.price();
                    break;
                case "3":
                    chips.price();
                    break;
                case "4":
                    checkout.displayCheckout();
                    break;
                case "0":
                    System.out.println("Cancelling order and returning to Home Menu");
                    return;
                default:
                    System.out.println("Error!");
            }

        }
    }
}