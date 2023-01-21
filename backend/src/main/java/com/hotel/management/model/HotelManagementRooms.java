package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Rooms")
public class HotelManagementRooms {
    @Id
    @GeneratedValue
    private long roomId;

    @Column(name="RoomNumber")
    private int roomNumber;

    @Column(name="HotelId")
    private long hotelId;

    @Column(name="RoomType")
    private String roomType;

    @Column(name="RoomCharges")
    private double roomCharges;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="creationDate")
    private Date creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="lastUpdated")
    private Date lastUpdated;

    public HotelManagementRooms() {

    }

    public HotelManagementRooms(int roomNumber, long hotelId, String roomType, double roomCharges) {
        this.roomNumber=roomNumber;
        this.hotelId=hotelId;
        this.roomType=roomType;
        this.roomCharges=roomCharges;
    }   

    public long getRoomId() {
        return roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public long getHotelId() {
        return hotelId;
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

    public void setHotelId(long hotelId) {
        this.hotelId=hotelId;
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
        return "Rooms [roomId=" + roomId + ", roomNumber=" + roomNumber + ", hotelId=" + hotelId + ", roomType=" + roomType + ", roomCharges=" + roomCharges + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated +"]";
    }
}
