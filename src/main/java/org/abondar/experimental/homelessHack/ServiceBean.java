/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.abondar.experimental.homelessHack;



import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonCreator;
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

        Model mod = new Model();
        mod.setName("Ahmed");
        String res = formJson(mod);
        return Response.ok(res).build();

    }

    @POST
    @Path("/test_post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postData(@QueryParam("name") String name) {

        Model model = new Model();
        model.setName(name);
        model.setCodeName("ss1_"+name);
        String res = formJson(model);
        return Response.ok(res).build();

    }

    @POST
    @Path("/test_post1")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postData(Model body) {

        System.out.println(body.toString());

        Model model = new Model();
        model.setName(body.getName());
        model.setCodeName(body.getCodeName());
        String res = formJson(model);
        return Response.ok(res).build();

    }

    private String formJson(Model mod) {

        ObjectMapper om = new ObjectMapper();

        String jsonInString = "";
        try {
            jsonInString = om.writeValueAsString(mod);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonInString;
    }
}
