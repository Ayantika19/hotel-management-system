package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Items")
public class HotelManagementItems {
    @Id
    @GeneratedValue
    private long itemId;

    @Column(name="ItemName")
    private String itemName;

    @Column(name="charges")
    private double charges;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="creationDate")
    private Date creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="lastUpdated")
    private Date lastUpdated;

    public HotelManagementItems() {

    }

    public HotelManagementItems(String itemName, double charges, Date creationDate, Date lastUpdated) {
        this.itemName=itemName;
        this.charges=charges;
        this.creationDate=creationDate;
        this.lastUpdated=lastUpdated;
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
        this.itemName=itemName;
    }

    public void setCharges(double charges) {
        this.charges=charges;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate=creationDate;
    }
    
    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated=lastUpdated;
    }

    @Override
    public String toString() {
	    return "Items [itemId=" + itemId + ", itemName=" + itemName + ", charges=" + charges + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }    
}