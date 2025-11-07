package com.pluralsight;
import java.util.Scanner;
public class Drink extends Items{
    //will have my drink options
    //to do - determine how I will be adding flavors

    private String flavor;
    private String size;
    Scanner scanner = new Scanner(System.in);
    String userInput = scanner.nextLine().trim();

    public Drink(String itemName, double itemPrice, String flavor, String size) {
        super(itemName, itemPrice);
        this.flavor = flavor;
        this.size = size;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double price(){
        //return 0 until i make the calculations
        System.out.print("What kind of Drink would you like: ");
        flavor = userInput;
        System.out.println("What size would you like:");
        switch (userInput){
            case "1":
                itemPrice = 2.00;
                break;
            case "2":
                itemPrice = 2.50;
                break;
            case "3":
                itemPrice = 3.00;
                break;
            default:
                System.out.println("Error!");
        }

        return itemPrice;
    }

//adding to string just in case its needed
    @Override
    public String toString() {
        return "Drink{" +
                "flavor='" + flavor + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
