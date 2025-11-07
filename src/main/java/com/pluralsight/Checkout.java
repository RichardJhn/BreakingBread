package com.pluralsight;

public class Checkout {
    public void displayCheckout(){

        String choice = "";
        while(!choice.equalsIgnoreCase("0")) {
            System.out.println("""
                    =========Home Screen=======
                    1) New Order
                    0) Exit
                    ===========================
                    Please enter your choice
                    ===========================
                    """);

            switch(choice.toString()){
                case "1":
                    break;

                case "2":
                    break;
            }

        }
    }
}
