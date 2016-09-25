package org.abondar.experimental.homelessHack.model;

/**
 * Created by alexabon on 9/24/2016.
 */
public class Organization {
    private int id;
    private String name;
    private String address;
    private String phone;
    private OrgRoles role;

    // just for lulz and demo
    private int TotalKg;

    private double lat;

    private double lon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OrgRoles getRole() {
        return role;
    }

    public void setRole(OrgRoles role) {
        this.role = role;
    }

    public int getTotalKg() {
        return TotalKg;
    }

    public void setTotalKg(int totalKg) {
        TotalKg = totalKg;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                '}';
    }
}
