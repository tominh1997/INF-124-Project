package com.hkr.db;

import com.hkr.model.Item;
import com.hkr.model.Order;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;


public class DatabaseUtils {

    private static DecimalFormat df2 = new DecimalFormat("#.##");
    public static ArrayList<Item> retrieveItemsByType(Connection connection, String type) {
        ArrayList<Item> products = new ArrayList<Item>();
        try {
            String query = "SELECT * from chocoholic_db.products where type = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            // Set the parameter represented by "?" in the query to the id we get from url,
            // num 1 indicates the first "?" in the query
            statement.setString(1, type.toLowerCase());
            ResultSet rs = statement.executeQuery();
            // Iterate through each row of rs
            while (rs.next()) {
                Item product = new Item();
                product.setName(rs.getString("name"));
                product.setId(rs.getString("id"));
                product.setDescription(rs.getString("description"));
                product.setType(type);
                product.setPrice(Double.parseDouble(df2.format(rs.getDouble("price"))));
                product.setImage1(product.convertToBase64(rs.getBlob("image1")));
                product.setImage2(product.convertToBase64(rs.getBlob("image2")));
                product.setImage3(product.convertToBase64(rs.getBlob("image3")));
                products.add(product);
            }
            connection.close();
            rs.close();
            statement.close();
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public static Item retrieveItemByID(Connection connection, String id) {
        Item product = new Item();
        try {
            String query = "SELECT * from chocoholic_db.products where id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            // Set the parameter represented by "?" in the query to the id we get from url,
            // num 1 indicates the first "?" in the query
            statement.setInt(1, Integer.parseInt(id));
            ResultSet rs = statement.executeQuery();
            // Iterate through each row of rs
            rs.next();
            product.setName(rs.getString("name"));
            product.setId(rs.getString("id"));
            product.setDescription(rs.getString("description"));
            product.setType(rs.getString("type"));
            product.setPrice(Double.parseDouble(df2.format(rs.getDouble("price"))));
            product.setImage1(product.convertToBase64(rs.getBlob("image1")));
            product.setImage2(product.convertToBase64(rs.getBlob("image2")));
            product.setImage3(product.convertToBase64(rs.getBlob("image3")));
            connection.close();
            rs.close();
            statement.close();
            return product;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static HashMap<String, String> AddOrder(Connection dbcon, Order order) {
        String name = order.getName();
        String phone = order.getPhone();
        String address = order.getAddress();
        String city = order.getCity();
        String state = order.getState();
        String country = order.getCountry();
        String zipCode = order.getZipcode();
        String shipping = order.getShipping();
        String card = order.getCard();
        String cvv = order.getCvv();
        HashMap<String, Item> cart = order.getCart();
        HashMap<String, String> response =  new HashMap<>();
        float item_subtotal =0;
        int order_number = 0;
        float total_before_tax =0;
        float grand_total =0;

        try {
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
                statement.setDouble(6, (it.getQuantity() * it.getPrice()) +
                        (it.getQuantity() * it.getPrice()) * (Double.valueOf(tax) / 100) + Integer.valueOf(shipping));
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
