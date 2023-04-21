package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.EntityListeners;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "rooms")
@EntityListeners(AuditingEntityListener.class)
public class Rooms {
    @Id
    @SequenceGenerator(name = "rooms_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rooms_seq")
    @Column(name = "roomid")
    private long roomId;

    @Column(name = "roomnumber", nullable = false)
    private int roomNumber;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "hotelid", referencedColumnName = "hotelid")
    private HotelDetails hotelDetails;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bookingid", referencedColumnName = "bookingid")
    private Reservation reservation;

    @Column(name = "roomtype", nullable = false)
    private String roomType;

    @Column(name = "roomcharges", nullable = false)
    private double roomCharges;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    public Rooms() {

    }

    public Rooms(int roomNumber, String roomType, double roomCharges) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomCharges = roomCharges;
    }

    public long getRoomId() {
        return roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRoomCharges() {
        return roomCharges;
    }

    public Date getcreationDate() {
        return creationDate;
    }

    public Date getlastUpdated() {
        return lastUpdated;
    }

    public HotelDetails getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(HotelDetails hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}