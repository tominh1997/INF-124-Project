package com.uci.chocoholic;
import com.uci.chocoholic.model.Item;
import com.uci.chocoholic.service.CheckOutService;
import com.uci.chocoholic.service.ChocoholicService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

@Path("/chocoholic")
public class ChocoholicResource {

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
