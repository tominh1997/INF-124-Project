package com.hkr;


import com.google.gson.Gson;
import com.hkr.db.DatabaseConnector;
import com.hkr.db.DatabaseUtils;
import com.hkr.model.Item;
import com.hkr.model.Order;
import com.hkr.service.CheckOutService;

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
        return Response.ok(gson.toJson(product)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/checkout")
    public Response getItemByID(Order order){
        return Response.ok().build();
    }

}
