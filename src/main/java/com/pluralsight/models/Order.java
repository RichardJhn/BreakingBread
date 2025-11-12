package com.pluralsight.models;

import com.pluralsight.Items;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    //for formating how my receipts will be printed?

    //to do - use this class to calculate customers total order cost

    private String orderID;
    private ArrayList<Items> items;
    private LocalDateTime time;

    public Order(String orderID, ArrayList<Items> items, LocalDateTime time) {
        this.orderID = orderID;
        this.items = items;
        this.time = time;
    }

    public String getOrderID() {
        return orderID;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public LocalDateTime getTime() {
        return time;
    }



}
