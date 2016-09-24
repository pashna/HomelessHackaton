/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.abondar.experimental.homelessHack.services;



import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.abondar.experimental.homelessHack.model.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author abondar
 */

public class ServiceBean {

    @GET
    @Path("/get_good")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGood(@QueryParam("type") String type) {
        GoodTypes gt = GoodTypes.getType(type);
        Good good = new Good();
        good.setId(1);
        good.setName("Carrot");
        good.setType(gt);

        String res = formJson(good);
        return Response.ok(res).build();

    }

    @GET
    @Path("/get_goods")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGoods(@QueryParam("type") String type) {
        List<Good> goods = new ArrayList<>();
        GoodTypes gt = GoodTypes.getType(type);

        Good good1 = new Good();
        good1.setId(1);
        good1.setName("Carrot");
        good1.setType(gt);

        Good good2 = new Good();
        good2.setId(2);
        good2.setName("Potato");
        good2.setType(gt);

        goods.add(good1);
        goods.add(good2);

        String res = formJson(goods);
        return Response.ok(res).build();

    }

    @GET
    @Path("/get_orgs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrgs(@QueryParam("type") String type) {
        List<Organization> orgs = new ArrayList<>();
        OrgRoles orgRole = OrgRoles.getType(type);

        Organization o1 = new Organization();
        o1.setId(1);
        o1.setName("Safeway");
        o1.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o1.setPhone("+1-408-444-44-44");
        o1.setRole(orgRole);

        Organization o2 = new Organization();
        o2.setId(1);
        o2.setName("Charity org.");
        o2.setAddress("95133 217 BlaBla str. Milpitas, CA");
        o2.setPhone("+1-408-444-44-44");
        o2.setRole(orgRole);

        orgs.add(o1);
        orgs.add(o2);

        String res = formJson(orgs);
        return Response.ok(res).build();

    }

    @POST
    @Path("/case_create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postData(@QueryParam("vegName") String vegName,
                             @QueryParam("weight") int weight,
                             @QueryParam("orgName") String orgName,
                             @QueryParam("expDate") String expDate) {

        Good good = new Good();
        good.setId(3);
        good.setName(vegName);
        good.setType(GoodTypes.Vegetables);

        Organization o = new Organization();
        o.setId(3);
        o.setName(orgName);
        o.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o.setPhone("+1-408-444-44-44");
        o.setRole(OrgRoles.Grocery);

        Case case1 = new Case();
        case1.setId(1);
        case1.setGood(good);
        case1.setGrocery(o);
        case1.setGoodWeight(weight);
        case1.setPubDate(LocalDate.now());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println(LocalDate.parse(expDate,dtf));
        case1.setExpDate( LocalDate.parse(expDate,dtf));
        String res = formJson(case1);
        return Response.ok(res).build();

    }

//    @POST
//    @Path("/test_post1")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response postData(Model body) {
//
//        String res = formJson(model);
//        return Response.ok(res).build();
//
//    }

    private String formJson(Object obj) {

        ObjectMapper om = new ObjectMapper();

        String jsonInString = "";
        try {
            jsonInString = om.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonInString;
    }
}
