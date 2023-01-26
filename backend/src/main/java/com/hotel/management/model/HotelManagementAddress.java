package com.hotel.management.model;

import java.io.Serializable;

import javax.persistence.Column;

public class HotelManagementAddress implements Serializable {
    @Column(name = "housenumber")
    private int housenumber;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private int pincode;

    public HotelManagementAddress() {

    }

    public HotelManagementAddress(int housenumber,String street, String city, int pincode) {
        this.housenumber=housenumber;
        this.street=street;
        this.city=city;
        this.pincode=pincode;
    }
    
    public int getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }   
}
