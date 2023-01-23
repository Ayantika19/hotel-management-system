package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.EntityListeners;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "items")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementItems {
    @Id
    @GeneratedValue
    @Column(name="itemid")
    private long itemId;

    //need to change
    @OneToMany
    @ManyToOne
    @JoinColumn(name="hotelid",referencedColumnName="hotelid")
    private HotelManagementHotelFacilities hotelManagementHotelFacilities; 

    @Column(name="itemname")
    private String itemName;

    @Column(name="charges")
    private double charges;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated")
    private Date lastUpdated;

    public HotelManagementItems() {

    }

    public HotelManagementItems(String itemName, double charges, Date creationDate, Date lastUpdated) {
        this.itemName=itemName;
        this.charges=charges;
        this.creationDate=creationDate;
        this.lastUpdated=lastUpdated;
    }

    public HotelManagementHotelFacilities getHotelManagementHotelFacilities() {
        return hotelManagementHotelFacilities;
    }

    public void setHotelManagementHotelFacilities(HotelManagementHotelFacilities hotelManagementHotelFacilities) {
        this.hotelManagementHotelFacilities=hotelManagementHotelFacilities;
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