package com.pluralsight;
import java.util.Scanner;
public class OrderScreen {
    Scanner scanner = new Scanner(System.in);
    public void loadOrderScreen(){

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

            switch(choice.toString()){
                case "1":
                case "2":
                case "3":
                case "4":
                case "0":
                default:
                    System.out.println("Error!");
            }

        }

    }
}
