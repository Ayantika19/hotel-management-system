package com.hotel.management.model;

import java.io.Serializable;

import javax.persistence.Column;

public class HotelManagementContactNumber implements Serializable {
    
    @Column(name = "countrycode")
    private int countrycode;

    @Column(name = "number")
    private int number;

    public HotelManagementContactNumber() {

    }

    public HotelManagementContactNumber(int countrycode,int number) {
        this.countrycode=countrycode;
        this.number=number;
    }
    
    public int getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(int countrycode) {
        this.countrycode = countrycode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}