package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.util.Collection;
import java.util.Date;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "hotel")
@EntityListeners(AuditingEntityListener.class)
public class HotelDetails {

    @Id
    @SequenceGenerator(name = "hotel_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
    @Column(name = "hotelid")
    private long hotelId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "locationid")
    private Location location;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "hotelitems", joinColumns = @JoinColumn(name = "hotelid", referencedColumnName = "hotelid"), inverseJoinColumns = @JoinColumn(name = "itemid", referencedColumnName = "itemid"))
    private Collection<Items> items;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "hoteldiscounts", joinColumns = @JoinColumn(name = "hotelid", referencedColumnName = "hotelid"), inverseJoinColumns = @JoinColumn(name = "discountid", referencedColumnName = "discountid"))
    private Collection<Discounts> discounts;

    @Column(name = "gym")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean gymAvailable;

    @Column(name = "swimmingpool")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean swimmingPoolAvailable;

    @Column(name = "parkingzone")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean parkingZoneAvailable;

    @Column(name = "hotelname", nullable = false)
    private String hotelName;

    @Column(name = "totalrooms", nullable = false)
    private int totalRooms;

    @Column(name = "roomsavailable", nullable = false)
    private int roomsAvailable;

    @Column(name = "carrent")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean carRentAvailable;

    @Column(name = "gamezone")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean gameZoneAvailable;

    @Column(name = "laundry")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean laundryAvailable;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    public HotelDetails() {

    }

    public HotelDetails(boolean gymAvailable, boolean swimmingPoolAvailable,
            boolean parkingZoneAvailable, String hotelName,
            int totalRooms, int roomsAvailable, boolean carRentAvailable, boolean gameZoneAvailable,
            boolean laundryAvailable, Date creationDate, Date lastUpdated) {
        this.gymAvailable = gymAvailable;
        this.swimmingPoolAvailable = swimmingPoolAvailable;
        this.parkingZoneAvailable = parkingZoneAvailable;
        this.hotelName=hotelName;
        this.totalRooms = totalRooms;
        this.roomsAvailable = roomsAvailable;
        this.carRentAvailable = carRentAvailable;
        this.gameZoneAvailable = gameZoneAvailable;
        this.laundryAvailable = laundryAvailable;
        this.creationDate = creationDate;
        this.lastUpdated = lastUpdated;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Collection<Items> getHotelItems() {
        return items;
    }

    public void setHotelItems(Collection<Items> items) {
        this.items = items;
    }

    public Collection<Discounts> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Collection<Discounts> discounts) {
        this.discounts = discounts;
    }

    public long getHotelId() {
        return hotelId;
    }

    public boolean getGymAvailable() {
        return gymAvailable;
    }

    public String getHotelName() {
        return hotelName;
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
        this.creationDate = creationDate;
    }

    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setGymAvailable(boolean gymAvailable) {
        this.gymAvailable = gymAvailable;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setSwimmingPoolAvailable(boolean swimmingPoolAvailable) {
        this.swimmingPoolAvailable = swimmingPoolAvailable;
    }

    public void setParkingZoneAvailable(boolean parkingZoneAvailable) {
        this.parkingZoneAvailable = parkingZoneAvailable;
    }

    public void setCarRentAvailable(boolean carRentAvailable) {
        this.carRentAvailable = carRentAvailable;
    }

    public void setGameZoneAvailable(boolean gameZoneAvailable) {
        this.gameZoneAvailable = gameZoneAvailable;
    }

    public void setLaundryAvailable(boolean laundryAvailable) {
        this.laundryAvailable = laundryAvailable;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public void setRoomsAvailable(int roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }
}