package com.uci.chocoholic.db;

import com.uci.chocoholic.model.Item;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class DatabaseUtils {

    private static DecimalFormat df2 = new DecimalFormat("#.##");
    public static ArrayList<Item> retrieveItemsByType(Connection connection, final String type) {
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

    public static Item retrieveItemByID(Connection connection, final String id) {
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


    public static boolean performDBUpdate(Connection connection, String sql, String... params) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);


            int i = 1;
            for (String param : params) {

                preparedStatement.setString(i++, param);

            }

            return preparedStatement.executeUpdate() > 0 ;

        } catch (SQLException e) {
            return false;
        }
    }
}
