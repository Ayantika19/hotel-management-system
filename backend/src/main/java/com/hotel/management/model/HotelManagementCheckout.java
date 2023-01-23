package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.EntityListeners;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "checkout")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementCheckout {
    @Id
    @GeneratedValue
    @Column(name="billingid")
    private long billingId;

    @OneToOne
    @JoinColumn(name="bookingid",referencedColumnName="bookingid")
    private HotelManagementReservation hotelManagementReservation;

    @OneToMany
    @ManyToOne
    @JoinColumn(name="itemid",referencedColumnName="itemid")
    private HotelManagementItems hotelManagementItems;

    @Column(name="paymentstatus")
    private String paymentStatus;

    @Column(name="gst")
    private double gst;

    @Column(name="totalcharges")
    private double totalCharges;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated")
    private Date lastUpdated;

    public HotelManagementCheckout() {

    }

    public HotelManagementCheckout(String paymentStatus, double gst, double totalCharges) {
        this.paymentStatus=paymentStatus;
        this.gst=gst;
        this.totalCharges=totalCharges;
    }

    public HotelManagementReservation getHotelManagementReservation() {
        return hotelManagementReservation;
    }

    public void setHotelManagementReservation(HotelManagementReservation hotelManagementReservation) {
        this.hotelManagementReservation=hotelManagementReservation;
    }

    public HotelManagementItems getHotelManagementItems() {
        return hotelManagementItems;
    }

    public void setHotelManagementItems(HotelManagementItems hotelManagementItems) {
        this.hotelManagementItems=hotelManagementItems;
    }
    
    public long getBillingId() {
        return billingId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public double getGST() {
        return gst;
    }

    public double getTotalCharges() {
        return totalCharges;
    }

    public Date getcreationDate() {
        return creationDate;
    }
    
    public Date getlastUpdated() {
        return lastUpdated;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus=paymentStatus;
    }

    public void setGST(double gst) {
        this.gst=gst;
    }

    public void setTotalCharges(double totalCharges) {
        this.totalCharges=totalCharges;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate=creationDate;
    }
    
    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated=lastUpdated;
    }

    @Override
    public String toString() {
	    return "Checkout [billingId=" + billingId + ", paymentStatus=" + paymentStatus + ", gst=" + gst + 
                        ", totalCharges=" + totalCharges + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }    
}