package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @SequenceGenerator(name="location_seq", allocationSize = 1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="location_seq")
    @Column(name = "locationid")
    private long locationId;

    @Column(name = "locationname", unique = true, nullable = false)
    private String locationName;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    public HotelManagementLocation() {

    }

    public HotelManagementLocation(String locationName, Date creationDate, Date lastUpdated) {
        this.locationName = locationName;
        this.creationDate = creationDate;
        this.lastUpdated = lastUpdated;
    }

    public long getLocationId() {
        return locationId;
    }

    // public Set<HotelManagementHotelDetails> getHotelManagementHotelDetails() {
    // return hotelManagementHotelDetails;
    // }

    // public void setHotelManagementHotelDetails(Set<HotelManagementHotelDetails>
    // hotelManagementHotelDetails) {
    // this.hotelManagementHotelDetails = hotelManagementHotelDetails;
    // }

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
        this.creationDate = creationDate;
    }

    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return "Location [locationId=" + locationId + ", locationName=" + locationName + ", creationDate="
                + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}
