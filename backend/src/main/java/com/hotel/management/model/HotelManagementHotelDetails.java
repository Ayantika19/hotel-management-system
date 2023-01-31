package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.EntityListeners;
import javax.persistence.Column;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "hotel")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementHotelDetails {
    
    @Id
    @GeneratedValue
    @Column(name="hotelid")
    private Long hotelId;

    @OneToMany(mappedBy = "hotelManagementHotelFacilities")
    private Set<HotelManagementLocation> hotelManagementLocation;

    @ManyToMany
    @JoinTable(name="hotelitems", joinColumns = @JoinColumn(name="hotelid",referencedColumnName = "hotelid"), 
                                                inverseJoinColumns = @JoinColumn(name="itemid", referencedColumnName = "itemid"))
    private Collection<HotelManagementItems> hotelManagementItems;

    @ManyToMany
    @JoinTable(name="hoteldiscounts", joinColumns = @JoinColumn(name="hotelid",referencedColumnName = "hotelid"), 
                                                    inverseJoinColumns = @JoinColumn(name="discountid", referencedColumnName = "discountid"))
    private Collection<HotelManagementDiscounts> hotelManagementDiscounts;

    @Column(name="gym")
    private boolean gymAvailable;

    @Column(name="swimmingpool")
    private boolean swimmingPoolAvailable;
    
    @Column(name="parkingzone")
    private boolean parkingZoneAvailable;

    @Column(name="totalrooms", nullable = false)
    private int totalRooms;

    @Column(name="roomsavailable", nullable = false)
    private int roomsAvailable;

    @Column(name="carrent")
    private boolean carRentAvailable;

    @Column(name="gamezone")
    private boolean gameZoneAvailable;

    @Column(name="laundry")
    private boolean laundryAvailable;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated", nullable = false)
    private Date lastUpdated;

    public HotelManagementHotelDetails() {

    }

    public HotelManagementHotelDetails(boolean gymAvailable, boolean swimmingPoolAvailable, boolean parkingZoneAvailable, 
                                          int totalRooms, int roomsAvailable, boolean carRentAvailable, boolean gameZoneAvailable, 
                                          boolean laundryAvailable, Date creationDate, Date lastUpdated) {
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
    
    public Set<HotelManagementLocation> getHotelManagementLocation() {
        return hotelManagementLocation;
    }

    public void setHotelManagementLocation(Set<HotelManagementLocation> hotelManagementLocation) {
        this.hotelManagementLocation=hotelManagementLocation;
    }

    public Collection<HotelManagementItems> getHotelManagementHotelItems() {
        return hotelManagementItems;
    }

    public void setHotelManagementHotelItems(Collection<HotelManagementItems> hotelManagementItems) {
        this.hotelManagementItems = hotelManagementItems;
    }

    public Collection<HotelManagementDiscounts> getHotelManagementDiscounts() {
        return hotelManagementDiscounts;
    }

    public void setHotelManagementDiscounts(Collection<HotelManagementDiscounts> hotelManagementDiscounts) {
        this.hotelManagementDiscounts = hotelManagementDiscounts;
    }

    public long getHotelId() {
        return hotelId;
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
	    return "HotelFacilities [hotelId=" + hotelId + ", gymAvailable=" + gymAvailable + ", swimmingPoolAvailable=" + swimmingPoolAvailable + ", parkingZoneAvailable=" + parkingZoneAvailable + ", carRentAvailable=" + carRentAvailable + ", gameZoneAvailable=" + gameZoneAvailable + ", laundryAvailable=" + laundryAvailable + ", totalRooms=" + totalRooms + ", roomsAvailable=" + roomsAvailable + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }   
}