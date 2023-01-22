package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Feedback")
public class HotelManagementFeedback {
    @Id
    @GeneratedValue
    private long feedbackId;

    @Column(name="GuestID")
    private long guestID;

    @Column(name="HotelID") // get it from location table
    private long hotelID;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="LocationName")
    private String locationName;

    @Column(name="EmailID")
    private String emailID;

    @Column(name="Ratings")
    private double ratings;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="creationDate")
    private Date creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="lastUpdated")
    private Date lastUpdated;

    public HotelManagementFeedback() {

    }

    public HotelManagementFeedback(long guestID, long hotelID, String firstName, String lastName, String locationName, String emailID, double ratings) {
        this.guestID=guestID;
        this.hotelID=hotelID;
        this.firstName=firstName;
        this.lastName=lastName;
        this.locationName=locationName;
        this.emailID=emailID;
        this.ratings=ratings;
    }
    
    public long getFeedbackId() {
        return feedbackId;
    }

    public long getHotelId() {
        return hotelID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getEmailID() {
        return emailID;
    }

    public double getRatings() {
        return ratings;
    }

    public Date getcreationDate() {
        return creationDate;
    }
    
    public Date getlastUpdated() {
        return lastUpdated;
    }

    public void setHotelID(long hotelID) {
        this.hotelID=hotelID;
    }

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public void setLocationName(String locationName) {
        this.locationName=locationName;
    }

    public void setEmailID(String emailID) {
        this.emailID=emailID;
    }

    public void setRatings(double ratings) {
        this.ratings=ratings;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate=creationDate;
    }
    
    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated=lastUpdated;
    }

    @Override
    public String toString() {
	    return "Feeedback [feedbackId=" + feedbackId + ", guestID=" + guestID + ", hotelID=" + hotelID + ", firstName=" + firstName + ", lastName=" + lastName + ", locationName=" + locationName + ", emailID=" + emailID + ", ratings=" + ratings + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }    
}