package com.pluralsight;
import java.util.Scanner;
public class HomeScreen {
     //will be using this class as my home screen
    //to do- make Order menu then move it here to make it neat
    public void displayHomeScreen() {
        Scanner scanner = new Scanner(System.in);

        String choice = "";
        while (!choice.equalsIgnoreCase("0")) {
            System.out.println("""
                    =========Home Screen=======
                    1) New Order
                    0) Exit
                    ===========================
                    Please enter your choice
                    ===========================
                    """);

            choice = scanner.next().trim();

            switch (choice.toString()) {
                case "1":
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
