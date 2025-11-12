package com.pluralsight.models;

import com.pluralsight.Chips;
import com.pluralsight.Drink;
import com.pluralsight.Items;
import com.pluralsight.Sandwich;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    //for formating how my receipts will be printed?

    //to do - use this class to calculate customers total order cost

    private String orderID;
    private List<Items> items;
    private LocalDateTime time;

    public Order(String orderID, List<Items> items, LocalDateTime time) {
        this.orderID = orderID;
        this.items = (items != null) ? items : new ArrayList<>();
        this.time = time != null ? time : LocalDateTime.now();
    }

    public String getOrderID() {
        return orderID;
    }

    public List<Items> getItems() {
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

        System.out.println("=======Order Summary======");
        System.out.println("Order id : " + orderID);
        System.out.println("Time : " + time);


        for (Items i : items){
            if (i instanceof Sandwich sandwich){
                System.out.println("=====Sandwich=====");
                System.out.println("Bread : " + sandwich.getBread());
                System.out.println("Size : " + sandwich.getSize());
                //add if its toasted or not
                System.out.printf("Price : $%.2f \n", sandwich.price());
                System.out.println("====================================\n");

            }
            if (i instanceof Drink drink){
                System.out.println("=====Drinks=====");
                System.out.println("Flavor : " + drink.getFlavor());
                System.out.println("Size : " + drink.getSize());
                System.out.printf("Price : $%.2f \n", drink.price());
                System.out.println("============================\n");


            }
            if (i instanceof Chips chips){
                System.out.println("=====Chips=====");
                System.out.println(((Chips) i).getChipType());
                System.out.printf("Price : $%.2f \n", chips.price());
                System.out.println("==========================\n");

            }
        }
    }

}
