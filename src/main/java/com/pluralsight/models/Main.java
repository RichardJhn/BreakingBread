package com.pluralsight.models;

import com.pluralsight.screens.HomeScreen;

public class Main {
    public static void main(String[] Args){
        //this makes a new home screen and then displays it
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.displayHomeScreen();
    }
}
