package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.EntityListeners;
import javax.persistence.OneToOne;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "feedback")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementFeedback {
    
    @Id
    @GeneratedValue
    @Column(name="feedbackid")
    private long feedbackId;

    @OneToOne
    @JoinColumn(name="bookingid",referencedColumnName="bookingid")
    private HotelManagementReservation hotelManagementReservation;

    @Column(name="ratings")
    private double ratings;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated")
    private Date lastUpdated;

    public HotelManagementFeedback() {

    }

    public HotelManagementFeedback(double ratings) {

        this.ratings=ratings;
    }
    
    public HotelManagementReservation getHotelManagementReservation() {
        return hotelManagementReservation;
    }

    public void setHotelManagementReservation(HotelManagementReservation hotelManagementReservation) {
        this.hotelManagementReservation=hotelManagementReservation;
    }

    public long getFeedbackId() {
        return feedbackId;
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
	    return "Feeedback [feedbackId=" + feedbackId + ", ratings=" + ratings + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }    
}