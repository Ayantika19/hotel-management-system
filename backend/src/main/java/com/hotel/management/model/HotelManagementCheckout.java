package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class HotelManagementCheckout {
    @Id
    @SequenceGenerator(name = "checkout_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkout_seq")
    @Column(name = "billingid")
    private long billingId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "checkoutitems", joinColumns = @JoinColumn(name = "billingid", referencedColumnName = "billingid"), inverseJoinColumns = @JoinColumn(name = "itemid", referencedColumnName = "itemid"))
    private Collection<HotelManagementItems> hotelManagementItems;

    @OneToOne
    @JoinColumn(name = "bookingid", referencedColumnName = "bookingid")
    private HotelManagementReservation hotelManagementReservation;

    @Column(name = "paymentstatus", nullable = false)
    private String paymentStatus;

    @Column(name = "gst", nullable = false)
    private double gst;

    @Column(name = "totalcharges", nullable = false)
    private double totalCharges;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    public HotelManagementCheckout() {

    }

    public HotelManagementCheckout(String paymentStatus, double gst, double totalCharges) {
        this.paymentStatus = paymentStatus;
        this.gst = gst;
        this.totalCharges = totalCharges;
    }

    public Collection<HotelManagementItems> getHotelManagementItems() {
        return hotelManagementItems;
    }

    public HotelManagementReservation getHotelManagementReservation() {
        return hotelManagementReservation;
    }

    public void setHotelManagementReservation(HotelManagementReservation hotelManagementReservation) {
        this.hotelManagementReservation = hotelManagementReservation;
    }

    public void setHotelManagementItems(Collection<HotelManagementItems> hotelManagementItems) {
        this.hotelManagementItems = hotelManagementItems;
    }

    public long getBillingId() {
        return billingId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public double getGST() {
        // HotelManagementItems itemcharges = new HotelManagementItems();
        // HotelManagementRooms roomcharges = new HotelManagementRooms();
        // gst = 0.18 * (itemcharges.getCharges() + roomcharges.getRoomCharges());
        return gst;
    }

    public double getTotalCharges() {
        // HotelManagementItems itemcharges = new HotelManagementItems();
        // HotelManagementRooms roomcharges = new HotelManagementRooms();
        // HotelManagementCheckout gst = new HotelManagementCheckout();
        // totalCharges = totalCharges + itemcharges.getCharges() + roomcharges.getRoomCharges() + gst.getGST();
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

    @Override
    public String toString() {
        return "Checkout [billingId=" + billingId + ", paymentStatus=" + paymentStatus + ", gst=" + gst +
                ", totalCharges=" + totalCharges + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated
                + "]";
    }
}