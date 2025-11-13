package com.pluralsight.models;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderWriter {

    //May scrap - ended up moving it to checkout

    public static void saveOrderToFIle(String orderDetails){
        //this will have the time the order was made
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd- HH:mm:ss");
        String timeStamp = LocalDateTime.now().format(formatter);
        String fileName = "Order:" + timeStamp + ".txt";

        File folder = new File("orders");
        if(!folder.exists()){
            folder.mkdir();

        }
        File file = new File(folder,fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write(orderDetails);
            System.out.println("Order has been saved successfully as :" + file.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error : Could not save file");
        }
    }





}
