package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.EntityListeners;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "rooms")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementRooms {
    @Id
    @GeneratedValue
    @Column(name="roomid")
    private long roomId;

    @Column(name="roomnumber")
    private int roomNumber;

    @OneToOne   //need to change
    @JoinColumn(name="hotelid",referencedColumnName="hotelid")
    private HotelManagementHotelFacilities hotelManagementHotelFacilities;

    @Column(name="roomtype")
    private String roomType;

    @Column(name="roomcharges")
    private double roomCharges;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated")
    private Date lastUpdated;

    public HotelManagementRooms() {

    }

    public HotelManagementRooms(int roomNumber, String roomType, double roomCharges) {
        this.roomNumber=roomNumber;
        this.roomType=roomType;
        this.roomCharges=roomCharges;
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

    public void setRoomNumber(int roomNumber) {
        this.roomNumber=roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType=roomType;
    }

    public void setRoomCharges(double roomCharges) {
        this.roomCharges=roomCharges;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate=creationDate;
    }
    
    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated=lastUpdated;
    }

    @Override
    public String toString() {
        return "Rooms [roomId=" + roomId + ", roomNumber=" + roomNumber + ", roomType=" + roomType + ", roomCharges=" + roomCharges + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated +"]";
    }
}
