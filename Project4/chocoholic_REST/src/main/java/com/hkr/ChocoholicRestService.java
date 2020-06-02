package com.hkr;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hkr.db.DatabaseConnector;
import com.hkr.db.DatabaseUtils;
import com.hkr.model.Item;
import com.hkr.model.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/chocoholic")

public class ChocoholicRestService{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/{type}")
    public Response getItemsByType(@PathParam("type") String type) throws SQLException, ClassNotFoundException {
        Connection dbcon = DatabaseConnector.initializeDatabase();
        ArrayList<Item> products = DatabaseUtils.retrieveItemsByType(dbcon, type);

        System.out.print(products.toString());
        if (products.size() == 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Gson gson = new Gson();
        System.out.println(gson.toJson(products));
        return Response.ok(gson.toJson(products)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/product/{id}")
    public Response getItemByID(@PathParam("id") String id) throws SQLException, ClassNotFoundException {
        Connection dbcon = DatabaseConnector.initializeDatabase();
        Item product = DatabaseUtils.retrieveItemByID(dbcon, id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Gson gson = new Gson();
        System.out.println(gson.toJson(product));
        return Response.ok(gson.toJson(product)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON )
    @Path("/checkout")
    public Response getConfirmation(String order) throws SQLException, ClassNotFoundException {
        System.out.println(order);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Order order1 = gson.fromJson(order, Order.class);
        System.out.println(order1.getCart());
        Connection dbcon = DatabaseConnector.initializeDatabase();
        HashMap<String, String> response = DatabaseUtils.AddOrder(dbcon, order1);
        if (response.isEmpty()){
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        System.out.println(gson.toJson(response));
        return Response.ok(gson.toJson(response)).build();
    }

}
