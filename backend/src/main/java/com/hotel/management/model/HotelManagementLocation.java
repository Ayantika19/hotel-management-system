package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.EntityListeners;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "location")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementLocation {
    
    @Id
    @GeneratedValue
    @Column(name="locationid")
    private Long locationId;

    @ManyToOne
    @JoinColumn(name = "hotelid", referencedColumnName = "hotelid", nullable = false)
    private HotelManagementHotelDetails hotelManagementHotelFacilities;

    @Column(name="locationname", nullable = false)
    private String locationName;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated", nullable = false)
    private Date lastUpdated;

    public HotelManagementLocation() {

    }

    public HotelManagementLocation(String locationName,Date creationDate, Date lastUpdated) {
        this.locationName=locationName;
        this.creationDate=creationDate;
        this.lastUpdated=lastUpdated;
    }

    public long getLocationId() {
        return locationId;
    }

    public HotelManagementHotelDetails getHotelManagementHotelFacilities() {
        return hotelManagementHotelFacilities;
    }

    public void setHotelManagementHotelFacilities(HotelManagementHotelDetails hotelManagementHotelFacilities) {
        this.hotelManagementHotelFacilities = hotelManagementHotelFacilities;
    }

    public String getLocationName() {
        return locationName;
    }

    public Date getcreationDate() {
        return creationDate;
    }   

    public Date getlastUpdated() {
        return lastUpdated;
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
	    return "Location [locationId=" + locationId + ", locationName=" + locationName + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}

