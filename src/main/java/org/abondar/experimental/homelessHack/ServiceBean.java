/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.abondar.experimental.homelessHack;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author abondar
 */

public class ServiceBean {

    @GET
    @Path("/test_get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {

        String res = formJson("hi Hui");
        return Response.ok(res).build();

    }

    @POST
    @Path("/test_post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postData(String param) {

        String res = param + " HUI";
        return Response.ok(res).build();

    }


    public String formJson(String test) {

        ObjectMapper om = new ObjectMapper();

        String jsonInString = "";
        try {
            jsonInString = om.writeValueAsString(test);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonInString;
    }
}
