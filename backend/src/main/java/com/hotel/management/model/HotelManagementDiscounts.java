package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.FetchType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "discounts")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementDiscounts {

    @Id
    @SequenceGenerator(name = "discount_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_seq")
    @Column(name = "discountid")
    private long discountId;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "hotelManagementDiscounts")
    @JsonIgnore
    private Collection<HotelManagementHotelDetails> hotelManagementHotelDetails;

    @Column(name = "companyname", unique = true, nullable = false)
    private String companyName;

    @Column(name = "housenumber")
    private int houseNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private long pincode;

    @Column(name = "emailid", unique = true, nullable = false)
    private String emailID;

    @Column(name = "countrycode", nullable = false)
    private String countrycode;

    @Column(name = "number", unique = true, nullable = false)
    private long number;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    public HotelManagementDiscounts() {

    }

    public HotelManagementDiscounts(String companyName, int houseNumber, String street, String city, long pincode,
            String emailID, String countrycode, long number) {

        this.companyName = companyName;
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.emailID = emailID;
        this.countrycode = countrycode;
        this.number = number;
    }

    public Collection<HotelManagementHotelDetails> getHotelManagementHotelDetails() {
        return hotelManagementHotelDetails;
    }

    public void setHotelManagementHotelDetails(Collection<HotelManagementHotelDetails> hotelManagementHotelDetails) {
        this.hotelManagementHotelDetails = hotelManagementHotelDetails;
    }

    public long getDiscountId() {
        return discountId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public long getPincode() {
        return pincode;
    }

    public String getCountryCode() {
        return countrycode;
    }

    public long getNumber() {
        return number;
    }

    public String getEmailID() {
        return emailID;
    }

    public Date getcreationDate() {
        return creationDate;
    }

    public Date getlastUpdated() {
        return lastUpdated;
    }

    // public HotelManagementReservation getHotelManagementReservation() {
    //     return hotelManagementReservation;
    // }

    // public void setHotelManagementReservation(HotelManagementReservation hotelManagementReservation) {
    //     this.hotelManagementReservation = hotelManagementReservation;
    // }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Discounts [discountId=" + discountId + ", companyName=" + companyName + ", houseNumber=" + houseNumber
                + ", street=" + street +
                ", city=" + city + ", pincode=" + pincode + ", emailID=" + emailID + ", countrycode=" + countrycode
                + ", number=" + number +
                ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}