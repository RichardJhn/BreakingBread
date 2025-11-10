package com.pluralsight;
import java.util.ArrayList;
public class OrderScreen {

    public void loadOrderScreen(){
        //HomeScreen homeScreen = new HomeScreen();
        Checkout checkout = new Checkout();
        ArrayList<Items> items = new ArrayList<>();
        Drink drink = new Drink();
        Chips chips = new Chips();
        Sandwich sandwich = new Sandwich();

        //to do - only have prompts inside of screen classes


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
                    //sandwich.price();
                    break;
                case "2":
                    proccessAddDrink();
                    break;
                case "3":
                    processAddChips();
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

    public void processAddSandwich(){
        // ask the user all of the information they need while building the sandwich...
        Sandwich sandwich = new Sandwich();

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

        String wantMeat = ConsoleHelper.promptForString("""
                Would you like toppings?
                ========================
                1) Yes
                2) No
                ========================
                Enter your choice here""");

        switch (wantMeat){
            case "1":
                String whatTopping = ConsoleHelper.promptForString("""
                        What type of toppings would you like?
                        =====================================
                        1) Meat
                        2) Cheese
                        =====================================
                        Enter your option here""");

                if (whatTopping.equalsIgnoreCase("1")){
                    String typeMeat = ConsoleHelper.promptForString("What kind of meat would you like");
                    int amountMeat = ConsoleHelper.promptForInt("How many extra pieces");
                    toppingsTotal = sandwich.meatToppingPrice(size, amountMeat);
                    sandwich.setToppings(typeMeat);

                } else if (whatTopping.equalsIgnoreCase("2")) {
                    String typeCheese = ConsoleHelper.promptForString("What kind of cheese would you like");
                    int amountCheese = ConsoleHelper.promptForInt("How many extra prices");
                    toppingsTotal = sandwich.cheeseToppingPrice(size,amountCheese);
                    sandwich.setToppings(typeCheese);

                }
                // to do - get user to choose from meat or cheese
                break;
            case "2":
                System.out.println("You did not pick any toppings");
                break;
            default:
                System.out.println("Error!");
        }
        //saving the total for toppings
        sandwich.setToppingsTotal(toppingsTotal);
        //calling sandwhich.price to calculate using the saved toppings total
        System.out.println(sandwich.price());

    }

    public void proccessAddDrink(){
        Drink drink = new Drink();
        String chosenFlavor = ConsoleHelper.promptForString
                ("What flavor soda would you like?");
        System.out.println("""
             What size would you like?
             ==========================
             1) Small
             2) Medium
             3) Large
             ===========================
            """);
        drink.setFlavor(chosenFlavor);

        String chosenSize = ConsoleHelper.promptForString("Enter your option:");
        drink.setSize(chosenSize);
        System.out.println(
                "Your soda is: " + chosenFlavor);
        drink.price();


        System.out.println();
    }

    public void processAddChips(){
        Chips chips = new Chips();
        String chipName = ConsoleHelper.promptForString("What type of chips would you like");
        chips.setChipType(chipName);
        chips.price();
        System.out.println("You chose: " + chipName);
        System.out.printf("Price: $%.2f", chips.itemPrice);
        System.out.println();
    }
}