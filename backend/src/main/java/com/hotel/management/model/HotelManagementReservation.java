package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.EntityListeners;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "reservation")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementReservation {

    @Id
    @SequenceGenerator(name = "reservation_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @Column(name = "bookingid")
    private long bookingId;

    @OneToOne
    @JoinColumn(name = "guestid", referencedColumnName = "guestid")
    private HotelManagementGuestRegistration hotelManagementGuestRegistration;

    @ManyToOne
    @JoinColumn(name = "hotelid", referencedColumnName = "hotelid")
    private HotelManagementHotelDetails hotelManagementHotelFacilities;

    @OneToMany(mappedBy = "hotelManagementReservation")
    @JsonIgnore
    private Set<HotelManagementRooms> hotelManagementRooms;

    @OneToOne
    @JoinColumn(name = "discountid", referencedColumnName = "discountid")
    private HotelManagementDiscounts hotelManagementDiscounts;

    @Column(name = "countrycode", nullable = false)
    private String countrycode;

    @Column(name = "number", unique = true, nullable = false)
    private long number;

    @Column(name = "housenumber", nullable = false)
    private int houseNumber;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "pincode", nullable = false)
    private long pincode;

    @Column(name = "bookingstatus")
    private String bookingStatus;

    @Column(name = "identityproof", unique = true, nullable = false)
    private long identityProof;

    @Temporal(TemporalType.DATE)
    @Column(name = "todate", nullable = false)
    private Date toDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "fromdate", nullable = false)
    private Date fromDate;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    public HotelManagementReservation() {

    }

    public HotelManagementReservation(int houseNumber, String street, String city, long pincode,
            String countrycode, long number, String bookingStatus, Date toDate, Date fromDate, long identityProof) {

        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.countrycode = countrycode;
        this.number = number;
        this.bookingStatus = bookingStatus;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.identityProof = identityProof;
    }

    public HotelManagementGuestRegistration getHotelManagementGuestRegistration() {
        return hotelManagementGuestRegistration;
    }

    public void setHotelManagementGuestRegistration(HotelManagementGuestRegistration hotelManagementGuestRegistration) {
        this.hotelManagementGuestRegistration = hotelManagementGuestRegistration;
    }

    public HotelManagementHotelDetails getHotelManagementHotelFacilities() {
        return hotelManagementHotelFacilities;
    }

    public void setHotelManagementHotelFacilities(HotelManagementHotelDetails hotelManagementHotelFacilities) {
        this.hotelManagementHotelFacilities = hotelManagementHotelFacilities;
    }

    public void setHotelManagementRooms(Set<HotelManagementRooms> hotelManagementRooms) {
        this.hotelManagementRooms = hotelManagementRooms;
    }

    public HotelManagementDiscounts getHotelManagementDiscounts() {
        return hotelManagementDiscounts;
    }

    public void setHotelManagementDiscounts(HotelManagementDiscounts hotelManagementDiscounts) {
        this.hotelManagementDiscounts = hotelManagementDiscounts;
    }

    public long getBookingId() {
        return bookingId;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public long getPincode() {
        return pincode;
    }

    public String getCountryCode() {
        return countrycode;
    }

    public long getNumber() {
        return number;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public long getIdentityProof() {
        return identityProof;
    }

    public Date getToDate() {
        return toDate;
    }

    public Date getFromDate() {
        return fromDate;
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

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setIdentityProof(long identityProof) {
        this.identityProof = identityProof;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public String toString() {
        return "Reservation [bookingId=" + bookingId + ", houseNumber=" + houseNumber + ", street=" + street + ", city="
                + city +
                ", pincode=" + pincode + ", countrycode=" + countrycode + ", number=" + number + ", bookingStatus="
                + bookingStatus +
                ", identityProof=" + identityProof + ", toDate=" + toDate + ", fromDate=" + fromDate + ", creationDate="
                + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}
