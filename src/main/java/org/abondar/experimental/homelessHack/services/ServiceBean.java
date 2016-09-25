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
import java.util.*;


/**
 * @author abondar
 */

public class ServiceBean {

    @GET
    @Path("/map_data")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mapData(){

        List<Map<String,List<Organization>>> dataToSend = new ArrayList<>();
        dataToSend.add(potatoData());
        dataToSend.add(carrotData());
        dataToSend.add(tomatoData());
        dataToSend.add(cucumberData());
        dataToSend.add(cabbageData());



        String res = formJson(dataToSend);
        return Response.ok(res).build();

    }

    @POST
    @Path("/case_create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response caseCreate(@QueryParam("vegName") String vegName,
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


    //
//    @POST
//    @Path("/test_post1")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response caseCreate(Model body) {
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

    // bullshit methods just for showing a proper json
    private Map<String,List<Organization>> potatoData(){
        List<Organization> potatoList = new ArrayList<>();

        Organization o1 = new Organization();
        o1.setId(1);
        o1.setName("Safeway");
        o1.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o1.setPhone("+1-408-444-44-44");
        o1.setRole(OrgRoles.Grocery);
        o1.setTotalKg(23);
        o1.setLat(37.402790);
        o1.setLon(-121.930980);

        Organization o2 = new Organization();
        o2.setId(2);
        o2.setName("Wallmart");
        o2.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o2.setPhone("+1-408-444-44-44");
        o2.setRole(OrgRoles.Grocery);
        o2.setTotalKg(20);
        o2.setLat(37.402790);
        o2.setLon(-121.930980);

        Organization o3 = new Organization();
        o3.setId(3);
        o3.setName("McDonalds");
        o3.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o3.setPhone("+1-408-444-44-44");
        o3.setRole(OrgRoles.Grocery);
        o3.setTotalKg(15);
        o3.setLat(37.402790);
        o3.setLon(-121.930980);

        Organization o4 = new Organization();
        o4.setId(4);
        o4.setName("SevenEleven");
        o4.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o4.setPhone("+1-408-444-44-44");
        o4.setRole(OrgRoles.Grocery);
        o4.setTotalKg(24);
        o4.setLat(37.402790);
        o4.setLon(-121.930980);

        Organization o5 = new Organization();
        o5.setId(5);
        o5.setName("PitStop");
        o5.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o5.setPhone("+1-408-444-44-44");
        o5.setRole(OrgRoles.Grocery);
        o5.setTotalKg(7);
        o5.setLat(37.402790);
        o5.setLon(-121.930980);

        Organization o6 = new Organization();
        o6.setId(6);
        o6.setName("FleaMarket");
        o6.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o6.setPhone("+1-408-444-44-44");
        o6.setRole(OrgRoles.Grocery);
        o6.setTotalKg(18);
        o6.setLat(37.402790);
        o6.setLon(-121.930980);

        Organization o7 = new Organization();
        o7.setId(7);
        o7.setName("Johny's Grocery");
        o7.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o7.setPhone("+1-408-444-44-44");
        o7.setRole(OrgRoles.Grocery);
        o7.setTotalKg(25);
        o7.setLat(37.402790);
        o7.setLon(-121.930980);

        Organization o8 = new Organization();
        o8.setId(8);
        o8.setName("Trader Joe's");
        o8.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o8.setPhone("+1-408-444-44-44");
        o8.setRole(OrgRoles.Grocery);
        o8.setTotalKg(27);
        o8.setLat(37.402790);
        o8.setLon(-121.930980);

        potatoList.add(o1);
        potatoList.add(o2);
        potatoList.add(o3);
        potatoList.add(o4);
        potatoList.add(o5);
        potatoList.add(o6);
        potatoList.add(o7);
        potatoList.add(o8);

        Map<String,List<Organization>> potatoMap = new HashMap<>();
        potatoMap.put("Potato",potatoList);
         return potatoMap;
    }

    private Map<String,List<Organization>> carrotData(){
        List<Organization> carrotList = new ArrayList<>();

        Organization o9 = new Organization();
        o9.setId(9);
        o9.setName("Safeway");
        o9.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o9.setPhone("+1-408-444-44-44");
        o9.setRole(OrgRoles.Grocery);
        o9.setTotalKg(14);
        o9.setLat(37.402790);
        o9.setLon(-121.930980);

        Organization o10 = new Organization();
        o10.setId(10);
        o10.setName("Wallmart");
        o10.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o10.setPhone("+1-408-444-44-44");
        o10.setRole(OrgRoles.Grocery);
        o10.setTotalKg(15);
        o10.setLat(37.402790);
        o10.setLon(-121.930980);

        Organization o11 = new Organization();
        o11.setId(11);
        o11.setName("FleaMarket");
        o11.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o11.setPhone("+1-408-444-44-44");
        o11.setRole(OrgRoles.Grocery);
        o11.setTotalKg(13);
        o11.setLat(37.402790);
        o11.setLon(-121.930980);

        Organization o12 = new Organization();
        o12.setId(12);
        o12.setName("Big Grocery");
        o12.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o12.setPhone("+1-408-444-44-44");
        o12.setRole(OrgRoles.Grocery);
        o12.setTotalKg(20);
        o12.setLat(37.402790);
        o12.setLon(-121.930980);

        Organization o13 = new Organization();
        o13.setId(13);
        o13.setName("Trader Joe's");
        o13.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o13.setPhone("+1-408-444-44-44");
        o13.setRole(OrgRoles.Grocery);
        o13.setTotalKg(22);
        o13.setLat(37.402790);
        o13.setLon(-121.930980);

        carrotList.add(o9);
        carrotList.add(o10);
        carrotList.add(o11);
        carrotList.add(o12);
        carrotList.add(o13);

        Map<String,List<Organization>> carrotMap = new HashMap<>();
        carrotMap.put("Carrot",carrotList);
        return carrotMap;
    }

    private Map<String,List<Organization>> tomatoData(){
        List<Organization> tomatoList = new ArrayList<>();

        Organization o14 = new Organization();
        o14.setId(14);
        o14.setName("SevenEleven");
        o14.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o14.setPhone("+1-408-444-44-44");
        o14.setRole(OrgRoles.Grocery);
        o14.setTotalKg(23);
        o14.setLat(37.402790);
        o14.setLon(-121.930980);

        Organization o15 = new Organization();
        o15.setId(15);
        o15.setName("Wallmart");
        o15.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o15.setPhone("+1-408-444-44-44");
        o15.setRole(OrgRoles.Grocery);
        o15.setTotalKg(18);
        o15.setLat(37.402790);
        o15.setLon(-121.930980);

        Organization o16 = new Organization();
        o16.setId(16);
        o16.setName("FleaMarket");
        o16.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o16.setPhone("+1-408-444-44-44");
        o16.setRole(OrgRoles.Grocery);
        o16.setTotalKg(25);
        o16.setLat(37.402790);
        o16.setLon(-121.930980);

        Organization o17 = new Organization();
        o17.setId(17);
        o17.setName("Jimmy's Grocery");
        o17.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o17.setPhone("+1-408-444-44-44");
        o17.setRole(OrgRoles.Grocery);
        o17.setTotalKg(5);
        o17.setLat(37.402790);
        o17.setLon(-121.930980);

        Organization o18 = new Organization();
        o18.setId(18);
        o18.setName("Trader Joe's");
        o18.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o18.setPhone("+1-408-444-44-44");
        o18.setRole(OrgRoles.Grocery);
        o18.setTotalKg(3);
        o18.setLat(37.402790);
        o18.setLon(-121.930980);

        tomatoList.add(o14);
        tomatoList.add(o15);
        tomatoList.add(o16);
        tomatoList.add(o17);
        tomatoList.add(o18);

        Map<String,List<Organization>> tomatoMap = new HashMap<>();
        tomatoMap.put("Tomato",tomatoList);
        return tomatoMap;
    }

    private Map<String,List<Organization>> cucumberData(){
        List<Organization> cucumberList = new ArrayList<>();

        Organization o19 = new Organization();
        o19.setId(19);
        o19.setName("Safeway");
        o19.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o19.setPhone("+1-408-444-44-44");
        o19.setRole(OrgRoles.Grocery);
        o19.setTotalKg(6);
        o19.setLat(37.402790);
        o19.setLon(-121.930980);

        Organization o20 = new Organization();
        o20.setId(20);
        o20.setName("Wallmart");
        o20.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o20.setPhone("+1-408-444-44-44");
        o20.setRole(OrgRoles.Grocery);
        o20.setTotalKg(30);
        o20.setLat(37.402790);
        o20.setLon(-121.930980);

        Organization o21 = new Organization();
        o21.setId(21);
        o21.setName("McDonalds");
        o21.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o21.setPhone("+1-408-444-44-44");
        o21.setRole(OrgRoles.Grocery);
        o21.setTotalKg(4);
        o21.setLat(37.402790);
        o21.setLon(-121.930980);

        Organization o22 = new Organization();
        o22.setId(22);
        o22.setName("SevenEleven");
        o22.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o22.setPhone("+1-408-444-44-44");
        o22.setRole(OrgRoles.Grocery);
        o22.setTotalKg(3);
        o22.setLat(37.402790);
        o22.setLon(-121.930980);

        Organization o23 = new Organization();
        o23.setId(23);
        o23.setName("PitStop");
        o23.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o23.setPhone("+1-408-444-44-44");
        o23.setRole(OrgRoles.Grocery);
        o23.setTotalKg(8);
        o23.setLat(37.402790);
        o23.setLon(-121.930980);

        Organization o24 = new Organization();
        o24.setId(24);
        o24.setName("FleaMarket");
        o24.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o24.setPhone("+1-408-444-44-44");
        o24.setRole(OrgRoles.Grocery);
        o24.setTotalKg(10);
        o24.setLat(37.402790);
        o24.setLon(-121.930980);

        Organization o25 = new Organization();
        o25.setId(25);
        o25.setName("Johny's Grocery");
        o25.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o25.setPhone("+1-408-444-44-44");
        o25.setRole(OrgRoles.Grocery);
        o25.setTotalKg(2);
        o25.setLat(37.402790);
        o25.setLon(-121.930980);

        Organization o26 = new Organization();
        o26.setId(26);
        o26.setName("Trader Joe's");
        o26.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o26.setPhone("+1-408-444-44-44");
        o26.setRole(OrgRoles.Grocery);
        o26.setTotalKg(8);
        o26.setLat(37.402790);
        o26.setLon(-121.930980);

        Organization o27 = new Organization();
        o27.setId(27);
        o27.setName("Big Grocery");
        o27.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o27.setPhone("+1-408-444-44-44");
        o27.setRole(OrgRoles.Grocery);
        o27.setTotalKg(7);
        o27.setLat(37.402790);
        o27.setLon(-121.930980);

        Organization o28 = new Organization();
        o28.setId(28);
        o28.setName("Jimmy's Grocery");
        o28.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o28.setPhone("+1-408-444-44-44");
        o28.setRole(OrgRoles.Grocery);
        o28.setTotalKg(12);
        o28.setLat(37.402790);
        o28.setLon(-121.930980);

        cucumberList.add(o19);
        cucumberList.add(o20);
        cucumberList.add(o21);
        cucumberList.add(o22);
        cucumberList.add(o23);
        cucumberList.add(o24);
        cucumberList.add(o25);
        cucumberList.add(o26);
        cucumberList.add(o27);
        cucumberList.add(o28);


        Map<String,List<Organization>> cucumberMap = new HashMap<>();
        cucumberMap.put("Cucmber",cucumberList);
        return cucumberMap;
    }

    private Map<String,List<Organization>> cabbageData(){
        List<Organization> cabbageList = new ArrayList<>();

        Organization o29 = new Organization();
        o29.setId(29);
        o29.setName("SevenEleven");
        o29.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o29.setPhone("+1-408-444-44-44");
        o29.setRole(OrgRoles.Grocery);
        o29.setTotalKg(6);
        o29.setLat(37.402790);
        o29.setLon(-121.930980);

        Organization o30 = new Organization();
        o30.setId(30);
        o30.setName("FleaMarket");
        o30.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o30.setPhone("+1-408-444-44-44");
        o30.setRole(OrgRoles.Grocery);
        o30.setTotalKg(12);
        o30.setLat(37.402790);
        o30.setLon(-121.930980);

        Organization o31 = new Organization();
        o31.setId(31);
        o31.setName("Johny's Grocery");
        o31.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o31.setPhone("+1-408-444-44-44");
        o31.setRole(OrgRoles.Grocery);
        o31.setTotalKg(9);
        o31.setLat(37.402790);
        o31.setLon(-121.930980);

        Organization o32 = new Organization();
        o32.setId(32);
        o32.setName("Big Grocery");
        o32.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o32.setPhone("+1-408-444-44-44");
        o32.setRole(OrgRoles.Grocery);
        o32.setTotalKg(16);
        o32.setLat(37.402790);
        o32.setLon(-121.930980);

        Organization o33 = new Organization();
        o33.setId(33);
        o33.setName("Jimmy's Grocery");
        o33.setAddress("95136 4100 BlaBla str. San Jose, CA");
        o33.setPhone("+1-408-444-44-44");
        o33.setRole(OrgRoles.Grocery);
        o33.setTotalKg(16);
        o33.setLat(37.402790);
        o33.setLon(-121.930980);

        cabbageList.add(o29);
        cabbageList.add(o30);
        cabbageList.add(o30);
        cabbageList.add(o31);
        cabbageList.add(o31);
        cabbageList.add(o32);
        cabbageList.add(o33);


        Map<String,List<Organization>> cabbageMap = new HashMap<>();
        cabbageMap.put("Cabbage",cabbageList);
        return cabbageMap;
    }

}
