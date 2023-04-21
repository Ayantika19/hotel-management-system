package com.hotel.management.model;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "checkout")
@EntityListeners(AuditingEntityListener.class)
public class Checkout {
    @Id
    @SequenceGenerator(name = "checkout_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkout_seq")
    @Column(name = "billingid")
    private long billingId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "checkoutitems", joinColumns = @JoinColumn(name = "billingid", referencedColumnName = "billingid"), inverseJoinColumns = @JoinColumn(name = "itemid", referencedColumnName = "itemid"))
    private Collection<Items> items;

    @OneToOne
    @JoinColumn(name = "bookingid", referencedColumnName = "bookingid")
    private Reservation reservation;

    @Column(name = "paymentstatus", nullable = false)
    private String paymentStatus;

    @Column(name = "gst")
    private double gst;

    @Column(name = "totalcharges")
    private double totalCharges;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    public Checkout() {

    }

    public Checkout(String paymentStatus, double gst, double totalCharges) {
        this.paymentStatus = paymentStatus;
        this.gst = gst;
        this.totalCharges = totalCharges;
    }

    public Collection<Items> getItems() {
        return items;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setItems(Collection<Items> items) {
        this.items = items;
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
        this.paymentStatus = paymentStatus;
    }

    public void setGST(double gst) {
        this.gst = gst;
    }

    public void setTotalCharges(double totalCharges) {
        this.totalCharges = totalCharges;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}