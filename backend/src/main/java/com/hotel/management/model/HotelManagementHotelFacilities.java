package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "HotelFacilities")
public class HotelManagementHotelFacilities {
    @Id
    @GeneratedValue
    private long hotelId;

    @Column(name="LocationID")
    private long locationId;

    @Column(name="Gym")
    private boolean gymAvailable;

    @Column(name="SwimmingPool")
    private boolean swimmingPoolAvailable;
    
    @Column(name="ParkingZone")
    private boolean parkingZoneAvailable;

    @Column(name="TotalRooms")
    private int totalRooms;

    @Column(name="RoomsAvailable")
    private int roomsAvailable;

    @Column(name="CarRent")
    private boolean carRentAvailable;

    @Column(name="GameZone")
    private boolean gameZoneAvailable;

    @Column(name="Laundry")
    private boolean laundryAvailable;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="creationDate")
    private Date creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="lastUpdated")
    private Date lastUpdated;

    public HotelManagementHotelFacilities() {

    }

    public HotelManagementHotelFacilities(long locationId, boolean gymAvailable, boolean swimmingPoolAvailable, boolean parkingZoneAvailable, 
                                          int totalRooms, int roomsAvailable, boolean carRentAvailable, boolean gameZoneAvailable, 
                                          boolean laundryAvailable, Date creationDate, Date lastUpdated) {
        this.locationId=locationId;
        this.gymAvailable=gymAvailable;
        this.swimmingPoolAvailable=swimmingPoolAvailable;
        this.parkingZoneAvailable=parkingZoneAvailable;
        this.totalRooms=totalRooms;
        this.roomsAvailable=roomsAvailable;
        this.carRentAvailable=carRentAvailable;
        this.gameZoneAvailable=gameZoneAvailable;
        this.laundryAvailable=laundryAvailable;
        this.creationDate=creationDate;
        this.lastUpdated=lastUpdated;
    }

    public long getHotelId() {
        return hotelId;
    }

    public long getLocationId() {
        return locationId;
    }

    public boolean getGymAvailable() {
        return gymAvailable;
    }

    public boolean getSwimmingPoolAvailable() {
        return swimmingPoolAvailable;
    }

    public boolean getParkingZoneAvailable() {
        return parkingZoneAvailable;
    }

    public boolean getCarRentAvailable() {
        return carRentAvailable;
    }

    public boolean getGameZoneAvailable() {
        return gameZoneAvailable;
    }

    public boolean getLaundryAvailable() {
        return laundryAvailable;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public Date getcreationDate() {
        return creationDate;
    }
    
    public Date getlastUpdated() {
        return lastUpdated;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate=creationDate;
    }
    
    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated=lastUpdated;
    }

    public void setLocationID(long locationId) {
        this.locationId=locationId;
    }

    public void setHotelID(long hotelID) {
        this.hotelId=hotelId;
    }

    public void setGymAvailable(boolean gymAvailable) {
        this.gymAvailable=gymAvailable;
    }

    public void setSwimingPoolAvailable(boolean swimmingPoolAvailable) {
        this.swimmingPoolAvailable=swimmingPoolAvailable;
    }

    public void setParkingZoneAvailable(boolean parkingZoneAvailable) {
        this.parkingZoneAvailable=parkingZoneAvailable;
    }

    public void setCarRentAvailable(boolean carRentAvailable) {
        this.carRentAvailable=carRentAvailable;
    }

    public void setGameZoneAvailable(boolean gameZoneAvailable) {
        this.gameZoneAvailable=gameZoneAvailable;
    }

    public void setLaundryAvailable(boolean laundryAvailable) {
        this.laundryAvailable=laundryAvailable;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms=totalRooms;
    }

    public void setRoomsAvailable(int roomsAvailable) {
        this.roomsAvailable=roomsAvailable;
    }

    @Override
    public String toString() {
	    return "HotelFacilities [hotelId=" + hotelId + ", locationId=" + locationId + ", gymAvailable=" + gymAvailable + ", swimmingPoolAvailable=" + swimmingPoolAvailable + ", parkingZoneAvailable=" + parkingZoneAvailable + ", carRentAvailable=" + carRentAvailable + ", gameZoneAvailable=" + gameZoneAvailable + ", laundryAvailable=" + laundryAvailable + ", totalRooms=" + totalRooms + ", roomsAvailable=" + roomsAvailable + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }   
}