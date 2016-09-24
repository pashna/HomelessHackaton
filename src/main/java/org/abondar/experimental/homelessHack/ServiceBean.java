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

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author abondar
 */

public class ServiceBean {


    @GET
    @Path("/test_get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {

        return Response.ok("HI").build();

    }

    @POST
    @Path("/test_post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postData(String param) {

        String res = param + " HUI";
        return Response.ok(res).build();

    }


    public void formJson(Event eb) {

        File fil = new File("/home/abondar/EventSearch/jsons/" + eb.getEventID() + ".json");
        try {
            FileOutputStream fos = new FileOutputStream(fil);
            ObjectMapper om = new ObjectMapper();
            om.writeValue(fos, eb);

        } catch (IOException ex) {
            Logger.getLogger(EventFinder.class.getName()).log(Level.SEVERE, null, ex);

        }


    }
}
