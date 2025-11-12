package com.pluralsight.screens;

import com.Sellables.Sandwich;
import com.pluralsight.*;
import com.pluralsight.models.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderScreen {

    //order declared up here...
    private Order currentOrder;



    public void loadOrderScreen(){
        //creating unique order inside of the order screen
        currentOrder = new Order("Order:" + System.currentTimeMillis(), new ArrayList<>(), LocalDateTime.now());



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
                    currentOrder.displayOrder();
                    CheckoutScreen checkoutScreen = new CheckoutScreen(currentOrder);
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
        //MenuItems menu = new MenuItems();

        // make calculation for only the sandwhich price here maybe?
        double baseSandwich = 0.00;
        double toppingsTotal = 0.00;
        //this is the get bread
        //make this like my chips and drinks and pull from my list made
        boolean onTheMenu = false;
        //to do - have a fail-safe for errors
        while (!onTheMenu) {
            StringBuilder breadMenu = new StringBuilder("""
                    Which type of bread would you like?
                    ==================================
                    1) Wheat
                    2) White
                    3) Rye
                    4) French
                    5) Whole Grain
                    ===================================
                    Enter your Option here""");
            int chosenBread = ConsoleHelper.promptForInt(breadMenu.toString());
            switch (chosenBread) {
                case 1, 2, 3, 4, 5 -> {
                    sandwich.setBread(MenuItems.bread[chosenBread - 1]);
                    onTheMenu = true;
                }
                default -> {
                    System.out.println("Error please try again");
                }

            }
        }
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

        //use my set regular, sides and premiums from menu item class
        do {
            String wantTopping = ConsoleHelper.promptForString("""
                    Please choose your additions
                    ========================
                    1) Premium(Meat/Cheese)
                    2) Regular
                    0) No toppings
                    ========================
                    Enter your choice here""");
            switch (wantTopping) {
                case "1":
                    String whatTopping = ConsoleHelper.promptForString("""
                            What type of premium toppings would you like?
                            =============================================
                            1) Meat
                            2) Cheese
                            =============================================
                            Enter your option here""");

                    switch (whatTopping){
                        case "1" -> {
                            StringBuilder meatMenu = new StringBuilder("""
                                    What type of meat would you like?
                                    ==================================
                                    1) Steak
                                    2) Pork
                                    3) Ham
                                    4) Turkey
                                    5) Salami
                                    ===================================
                                    Enter your choice here""");
                            int chosenMeat = ConsoleHelper.promptForInt(meatMenu.toString());
                            String typeMeat = MenuItems.meat[chosenMeat -1];

                            int extraMeat = ConsoleHelper.promptForInt("How many extra Pieces");
                            Topping topping = new Topping("Meat", typeMeat, extraMeat);
                            sandwich.addTopping(topping);

                            System.out.printf("%s has been added. Total price: $%.2f \n",typeMeat, sandwich.getPrice());

                        }
                        case "2" -> {
                            StringBuilder cheeseMenu = new StringBuilder("""
                                    What type of cheese would you like?
                                    ===================================
                                    1) American
                                    2) Bleu
                                    3) Three-Cheese
                                    4) Mozzarella
                                    ====================================
                                    Enter your option here""");
                            int chosenCheese = ConsoleHelper.promptForInt(cheeseMenu.toString());
                            String typeCheese = MenuItems.cheese[chosenCheese -1];
                            //may not print in receipts as I would like to
                            int extraCheese = ConsoleHelper.promptForInt("How many extra pieces would you like");
                            Topping topping = new Topping("Cheese",typeCheese, extraCheese);

                            sandwich.addTopping(topping);
                            System.out.printf("%s has been added. Total price: $%.2f \n",typeCheese, sandwich.getPrice());

                        }

                    }

//                    if (whatTopping.equalsIgnoreCase("1")) {
//                        String typeMeat = ConsoleHelper.promptForString("What kind of meat would you like");
//                        Topping toppings = new Topping("Meat", typeMeat);
//                        int amountMeat = ConsoleHelper.promptForInt("How many extra pieces");
//                        toppingsTotal = toppings.meatToppingPrice(size, amountMeat);
//                        sandwich.setToppings(typeMeat);
//
//
//                    } else if (whatTopping.equalsIgnoreCase("2")) {
//                        String typeCheese = ConsoleHelper.promptForString("What kind of cheese would you like");
//                        Topping toppings = new Topping("Cheese", typeCheese);
//                        int amountCheese = ConsoleHelper.promptForInt("How many extra prices");
//                        toppingsTotal = toppings.cheeseToppingPrice(size, amountCheese);
//                        sandwich.setToppings(typeCheese);

                    //}
                    break;
                case "2":
                    int chosenRegular = ConsoleHelper.promptForInt("""
                            Which of the normal toppings would you like?
                            ============================================
                            1) Lettuce
                            2) Peppers
                            3) Onions
                            4) Tomatoes
                            5) Jalapeno
                            6) Cucumber
                            7) Pickles
                            8) Guacamole
                            9) Mushrooms
                            =============================================
                            Enter your option here""");
                    if(chosenRegular < 1 || chosenRegular > MenuItems.regularToppings.length){
                       System.out.println("Error try again");
                        break;
                    }
                    //using the same logic as my processAddChips
                    String typeRegular = MenuItems.regularToppings[chosenRegular - 1];
                    Topping topping = new Topping("Regular", typeRegular, 0);
                    sandwich.addTopping(topping);
                    //placeholder for regular toppings
                    System.out.println(typeRegular + " has been added. No extra charges.");
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

            moreToppings = ConsoleHelper.promptForString("""
                    Would you like to add more toppings?
                    ====================================
                    1) Yes
                    2) No
                    ====================================
                    Enter your choice here""");


        } while (moreToppings.equals("1"));
        double totalSandwich = sandwich.getPrice() + toppingsTotal;
        System.out.printf("The total for this sandwich is:  $%.2f \n", totalSandwich);
        currentOrder.addItem(sandwich);

        //to do - will display what the customer has picked and tell them the price for the sandwich

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
        drink.getPrice();

        currentOrder.addItem(drink);
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

        chips.getPrice();
        System.out.println("You chose: " + chips.getChipType());
        System.out.printf("Price: $%.2f", chips.getPrice());
        System.out.println();
        currentOrder.addItem(chips);
    }

}