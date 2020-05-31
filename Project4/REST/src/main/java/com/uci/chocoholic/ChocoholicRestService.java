package com.uci.chocoholic;

import com.uci.chocoholic.db.DatabaseConnector;
import com.uci.chocoholic.db.DatabaseUtils;
import com.uci.chocoholic.model.Item;
import com.uci.chocoholic.service.CheckOutService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@Path("/chocoholic")
public class ChocoholicRestService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{type}")
    public String getItemsByType(@PathParam("type") String type) throws SQLException, ClassNotFoundException {
        Connection dbcon = DatabaseConnector.initializeDatabase();
        ArrayList<Item> products = DatabaseUtils.retrieveItemsByType(dbcon, type);
        String productNames = "";
        for (Item item: products){
            productNames += item.getName() + "\n";
        }
        return productNames;
//        if (products.size() == 0) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//        return Response.ok(products).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/product/{id}")
    public String getItemByID(@PathParam("id") String id) throws SQLException, ClassNotFoundException {
        Connection dbcon = DatabaseConnector.initializeDatabase();
        Item product = DatabaseUtils.retrieveItemByID(dbcon, id);
        return product.getName();
//        if (product == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//        return Response.ok(product).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON}) //This method accepts a request of the JSON type
    public Response addOrder(String name,
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

        //The todo object here is automatically constructed from the json request. Jersey is so cool!
        HashMap<String, String> responseValue = CheckOutService.AddOrder(name, phone, address, city, state, country, zipCode, shipping, card, cvv, cart);
        if(responseValue.size() != 0) {
            Response.status(Response.Status.OK).entity(responseValue).build();
        }

        // Return an Internal Server error because something wrong happened. This should never be executed
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
