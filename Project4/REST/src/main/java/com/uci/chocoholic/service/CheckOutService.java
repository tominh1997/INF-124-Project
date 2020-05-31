package com.uci.chocoholic.service;

import com.uci.chocoholic.db.DatabaseConnector;
import com.uci.chocoholic.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.HashMap;


public class CheckOutService {

    public static HashMap<String, String> AddOrder(String name,
                                   String phone,
                                   String address,
                                   String city,
                                   String state,
                                   String country,
                                   String zipCode,
                                   String shipping,
                                   String card,
                                   String cvv,
                                   HashMap<String, Item> cart) {
        HashMap<String, String> response =  new HashMap<>();
        float item_subtotal =0;
        int order_number = 0;
        float total_before_tax =0;
        float grand_total =0;

        try {
            Connection dbcon = DatabaseConnector.initializeDatabase();

            String query = "SELECT * FROM chocoholic_db.tax_rates WHERE ZipCode=?";
            PreparedStatement statement1 = dbcon.prepareStatement(query);
            statement1.setInt(1, Integer.parseInt(zipCode));
            ResultSet rs = statement1.executeQuery();
            rs.next();
            double tax = rs.getDouble("CombinedRate");
            String query1 = "INSERT INTO orders VALUES (NULL, ? , ? , ?, ? , ?, ? , ?, ? , ?, ? )";
            for (Item it : cart.values()) {
                PreparedStatement statement = dbcon.prepareStatement(query1);
                statement.setString(1, name);
                statement.setString(2, phone);
                statement.setInt(3, Integer.valueOf(it.getId()));
                statement.setString(4, it.getName());
                statement.setInt(5, it.getQuantity());
                statement.setDouble(6, it.getQuantity() * it.getPrice() * Double.valueOf(tax));
                item_subtotal += (it.getQuantity() * it.getPrice());

                statement.setString(7, address + " " + city + " " + state + " " + country + " " + zipCode);
                statement.setInt(8, Integer.valueOf(shipping));
                statement.setString(9, card);
                statement.setInt(10, Integer.valueOf(cvv));

                order_number = statement.executeUpdate();
                statement.close();

            }
            statement1.close();
            rs.close();
            dbcon.close();
            DecimalFormat df2 = new DecimalFormat("#.##");
            response.put("name", name);
            response.put("shipping", shipping);
            response.put("tax", String.valueOf(tax));
            response.put("item_subtotal", df2.format(item_subtotal));
            response.put("order_number", String.valueOf(order_number));
            response.put("shipping", shipping);
            total_before_tax = (float) (item_subtotal + Float.valueOf(shipping));
            grand_total = (float) (total_before_tax * tax/100.0 + total_before_tax);
            response.put("total_before_tax", df2.format(total_before_tax));
            response.put("grand_total", df2.format(grand_total));

        } catch (Exception e) {
            System.out.println(e);
        }
        return response;
    }

}
