package com.pluralsight.models;
import com.pluralsight.Sellables.Chips;
import com.pluralsight.Sellables.Drink;
import com.pluralsight.Sellables.Items;
import com.pluralsight.Sellables.Sandwich;
import com.pluralsight.Sellables.Topping;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    //this class takes care of a single order

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
            total += i.getPrice();
        }
        return total;
    }
    //this displays the order as the customer has picked out
    public void displayOrder() {

        System.out.println("=======Order Summary======");
        System.out.println("Order id : " + orderID);
        System.out.println("Time : " + time);

        for (Items i : items){
            if (i instanceof Sandwich sandwich){
                System.out.println("=====Sandwich=====\n");
                System.out.println("Bread : " + sandwich.getBread());
                System.out.println("Size : " + sandwich.getSize());
                System.out.println("Toasted : " + (sandwich.isToasted() ? "Yes" : "No"));

                System.out.println("Toppings : ");
                for(Topping t : sandwich.getToppings()){
                    System.out.println(t.getName());
                    if(t.getExtra() > 0)
                        System.out.println("extra: " + t.getExtra());
                    System.out.println();
                }
                System.out.printf("Price : $%.2f \n\n", sandwich.getPrice());

            }
            if (i instanceof Drink drink){
                System.out.println("=====Drinks=====\n");
                System.out.println("Flavor : " + drink.getFlavor());
                System.out.println("Size : " + drink.getSize());
                System.out.printf("Price : $%.2f \n\n", drink.getPrice());

            }
            if (i instanceof Chips chips){
                System.out.println("=====Chips=====\n");
                System.out.println(((Chips) i).getChipType());
                System.out.printf("Price : $%.2f \n\n", chips.getPrice());

            }
        }
    }

}
