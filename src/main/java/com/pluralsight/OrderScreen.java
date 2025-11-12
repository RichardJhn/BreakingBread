package com.pluralsight;

import java.util.Arrays;

public class OrderScreen {

    public void loadOrderScreen(){
        CheckoutScreen checkoutScreen = new CheckoutScreen();

        //fixed formatting
        //to do
        //- in processAddSandwich, allow customer to try again if they make an error
        //- add a set menu so when user inputs something not on menu, output "error try again!"
        //- add toasted option
        //- add included toppings that cost nothing -> (Will be part of set menu and user will not be able to choose anything else)

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
                    processAddSandwich();
                    break;
                case "2":
                    proccessAddDrink();
                    break;
                case "3":
                    processAddChips();
                    break;
                case "4":
                    checkoutScreen.displayCheckout();
                    break;
                case "0":
                    System.out.println("Cancelling order and returning to Home Menu");
                    return;
                default:
                    System.out.println("Error!");
            }

        }
    }

    public void processAddSandwich(){
        // ask the user all of the information they need while building the sandwich...
        Sandwich sandwich = new Sandwich();
        MenuItems menu = new MenuItems();

        // make calculation for only the sandwhich price here maybe?
        double baseSandwich = 0.00;
        double toppingsTotal = 0.00;
        //this is the get bread
        String typeBread = ConsoleHelper.promptForString("What kind of bread would you like");
        sandwich.setBread(typeBread);
        //to do - fix structuring
        String size = ConsoleHelper.promptForString("""
                What size sandwich would you like?
                ==================================
                1) small ($5.50)
                2) medium ($7.00)
                3) large ($8.50)
                ==================================
                Enter your option here""");
        sandwich.setSize(size);
        //This assumes the first time is true and loops it once
        String moreToppings = "1";
        do {
            String wantTopping = ConsoleHelper.promptForString("""
                    Please choose your topping
                    ========================
                    1) Premium(Meat/Cheese)
                    2) Regular
                    0) No toppings
                    ========================
                    Enter your choice here""");
            switch (wantTopping) {
                case "1":
                    String whatTopping = ConsoleHelper.promptForString("""
                            What type of toppings would you like?
                            =====================================
                            1) Meat
                            2) Cheese
                            3) Regular
                            =====================================
                            Enter your option here""");

                    if (whatTopping.equalsIgnoreCase("1")) {
                        String typeMeat = ConsoleHelper.promptForString("What kind of meat would you like");
                        Toppings toppings = new Toppings("Meat", typeMeat);
                        int amountMeat = ConsoleHelper.promptForInt("How many extra pieces");
                        toppingsTotal = toppings.meatToppingPrice(size, amountMeat);
                        sandwich.setToppings(typeMeat);

                    } else if (whatTopping.equalsIgnoreCase("2")) {
                        String typeCheese = ConsoleHelper.promptForString("What kind of cheese would you like");
                        Toppings toppings = new Toppings("Cheese", typeCheese);
                        int amountCheese = ConsoleHelper.promptForInt("How many extra prices");
                        toppingsTotal = toppings.cheeseToppingPrice(size, amountCheese);
                        sandwich.setToppings(typeCheese);

                    }
                    break;
                case "0":
                    System.out.println("You did not pick any toppings");
                    break;
                default:
                    System.out.println("Error!");
            }
            //saving the total for toppings
            sandwich.setToppingsTotal(toppingsTotal);
            //calling sandwich.price to calculate using the saved toppings total
            sandwich.price();

            moreToppings = ConsoleHelper.promptForString("""
                    Would you like to add more toppings?
                    ====================================
                    1) Yes
                    2) No
                    Enter your choice here
                    ====================================
                    """);


        } while (moreToppings.equals("1"));

    }

    public void proccessAddDrink(){
        Drink drink = new Drink();
        StringBuilder drinkMenu = new StringBuilder("""
                What soda would you like
                ========================
                1) Coke
                2) Pepsi
                3) Dr.Pepper
                4) Sprite
                Enter your Option here""");
        int chosenFlavor = ConsoleHelper.promptForInt(drinkMenu.toString());
        drinkMenu.append("Enter your option here");
        switch (chosenFlavor){
            case 1, 2, 3, 4 -> drink.setFlavor(MenuItems.drinks[chosenFlavor -1]);
        }
        System.out.println("""
             What size would you like?
             ==========================
             1) Small
             2) Medium
             3) Large
             ===========================
            """);
        String chosenSize = ConsoleHelper.promptForString("Enter your option:");
        drink.setSize(chosenSize);
        System.out.println(
                "Your soda is: " + drink.getFlavor());
        drink.price();


        System.out.println();
    }

    public void processAddChips(){
        Chips chips = new Chips();
        StringBuilder chipsMenu = new StringBuilder("""
                What chips would you like
                ========================
                1) Doritos
                2) Cheetos
                3) Takis
                4) Hot Fries
                """);
        int chosenFlavor = ConsoleHelper.promptForInt(chipsMenu + "Enter your choice here: ");

        switch (chosenFlavor){
            case 1, 2, 3, 4 -> chips.setChipType(MenuItems.chips[chosenFlavor - 1]);
            default -> {
                System.out.println("Invalid option please try again!");
            return;
            }
        }


        chips.price();
        System.out.println("You chose: " + chips.getChipType());
        System.out.printf("Price: $%.2f", chips.itemPrice);
        System.out.println();
    }
}