package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Checkout")
public class HotelManagementCheckout {
    @Id
    @GeneratedValue
    private long billingId;

    @Column(name="PaymentStatus")
    private String paymentStatus;

    @Column(name="GST")
    private double gst;

    @Column(name="TotalCharges")
    private double totalCharges;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="creationDate")
    private Date creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="lastUpdated")
    private Date lastUpdated;

    public HotelManagementCheckout() {

    }

    public HotelManagementCheckout(String paymentStatus, double gst, double totalCharges) {
        this.paymentStatus=paymentStatus;
        this.gst=gst;
        this.totalCharges=totalCharges;
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
	    return "Checkout [billingId=" + billingId + ", paymentStatus=" + paymentStatus + ", gst=" + gst + ", totalCharges=" + totalCharges + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }    
}