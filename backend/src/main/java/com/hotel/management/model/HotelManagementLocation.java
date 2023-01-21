package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Location")
public class HotelManagementLocation {
    @Id
    @GeneratedValue
    private long locationId;

    @Column(name="LocationName")
    private String locationName;

    @Column(name="HotelId")
    private long hotelId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="creationDate")
    private Date creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="lastUpdated")
    private Date lastUpdated;

    public HotelManagementLocation() {

    }

    public HotelManagementLocation(String locationName, long hotelId, Date creationDate, Date lastUpdated) {
        this.locationName=locationName;
        this.hotelId=hotelId;
        this.creationDate=creationDate;
        this.lastUpdated=lastUpdated;
    }

    public long getLocationId() {
        return locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public long getHotelId() {
        return hotelId;
    }

    public Date getcreationDate() {
        return creationDate;
    }   

    public Date getlastUpdated() {
        return lastUpdated;
    }

    public void setHotelId(long hotelId) {
        this.hotelId=hotelId;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate=creationDate;
    }

    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated=lastUpdated;
    }

    public void setLocationName(String locationName) {
        this.locationName=locationName;
    }

    @Override
    public String toString() {
	    return "Location [hotelID=" + hotelId + ", locationId=" + locationId + ", locationName=" + locationName + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}

