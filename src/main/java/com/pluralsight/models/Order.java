package com.pluralsight.models;

import com.pluralsight.Chips;
import com.pluralsight.Drink;
import com.pluralsight.Items;
import com.pluralsight.Sandwich;

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
    public void addItem(Items item){
        items.add(item);
    }
    public double totalPrice(){
        double total = 0;
        for (Items i : items){
            total += i.price();
        }
        return total;
    }

    public void displayOrder() {

        for (Items i : items){
            if (i instanceof Sandwich){

            }
            if (i instanceof Drink){

            }
            if (i instanceof Chips){

            }
        }
    }

}
