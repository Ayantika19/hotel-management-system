package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Column;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "items")
@EntityListeners(AuditingEntityListener.class)
public class Items {
    @Id
    @SequenceGenerator(name = "items_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "items_seq")
    @Column(name = "itemid")
    private long itemId;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "items")
    @JsonIgnore
    private Collection<HotelDetails> hotelDetails;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "items")
    @JsonIgnore
    private Collection<Checkout> checkout;

    @Column(name = "itemname", unique = true, nullable = false)
    private String itemName;

    @Column(name = "charges", nullable = false)
    private double charges;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    public Items() {

    }

    public Items(String itemName, double charges, Date creationDate, Date lastUpdated) {
        this.itemName = itemName;
        this.charges = charges;
        this.creationDate = creationDate;
        this.lastUpdated = lastUpdated;
    }

    public Collection<Checkout> getCheckout() {
        return checkout;
    }

    public void setHotelManagementCheckout(Collection<Checkout> checkout) {
        this.checkout = checkout;
    }

    public Collection<HotelDetails> getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(Collection<HotelDetails> hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getCharges() {
        return charges;
    }

    public Date getcreationDate() {
        return creationDate;
    }

    public Date getlastUpdated() {
        return lastUpdated;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
