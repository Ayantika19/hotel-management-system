package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.EntityListeners;
import javax.persistence.Lob;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "reservation")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementReservation {
    
    @Id
    @GeneratedValue
    @Column(name="bookingid")
    private long bookingId;   
    
    @OneToOne
    @JoinColumn(name="guestid",referencedColumnName="guestid")
    private HotelManagementGuestRegistration hotelManagementGuestRegistration;

    @OneToOne
    @JoinColumn(name="hotelid",referencedColumnName="hotelid")
    private HotelManagementHotelFacilities hotelManagementHotelFacilities;

    @ManyToOne
    @JoinColumn(name="roomid",referencedColumnName="roomid")
    private HotelManagementRooms hotelManagementRooms;

    @OneToOne
    @JoinColumn(name="discountid",referencedColumnName="discountid")
    private HotelManagementDiscounts hotelManagementDiscounts;

    @Column(name="locationname")
    private String locationName;

    @Column(name="address")
    private String guestAddress;

    @Column(name="bookingstatus")
    private String bookingStatus;

    @Lob 
	@Column(name = "identityproof", columnDefinition="BLOB") 
	private byte[] identityProof;

    @Temporal(TemporalType.DATE)
    @Column(name="todate")
    private Date toDate;

    @Temporal(TemporalType.DATE)
    @Column(name="fromdate")
    private Date fromDate;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated")
    private Date lastUpdated;

    public HotelManagementReservation() {

    }

    public HotelManagementReservation(String locationName, String guestAddress, String bookingStatus, Date toDate, Date fromDate, byte[] identityProof) {
        
        this.locationName=locationName;
        this.guestAddress=guestAddress;
        this.bookingStatus=bookingStatus;
        this.toDate=toDate;
        this.fromDate=fromDate;
        this.identityProof=identityProof;                                   
    }
    
    public HotelManagementGuestRegistration getHotelManagementGuestRegistration() {
        return hotelManagementGuestRegistration;
    }

    public void setHotelManagementGuestRegistration(HotelManagementGuestRegistration hotelManagementGuestRegistration) {
        this.hotelManagementGuestRegistration=hotelManagementGuestRegistration;
    }

    public HotelManagementHotelFacilities getHotelManagementHotelFacilities() {
        return hotelManagementHotelFacilities;
    }

    public void setHotelManagementHotelFacilities(HotelManagementHotelFacilities hotelManagementHotelFacilities) {
        this.hotelManagementHotelFacilities=hotelManagementHotelFacilities;
    }

    public HotelManagementRooms getHotelManagementRooms() {
        return hotelManagementRooms;
    }

    public void setHotelManagementRooms(HotelManagementRooms hotelManagementRooms) {
        this.hotelManagementRooms=hotelManagementRooms;
    }

    public HotelManagementDiscounts hotelManagementDiscounts(HotelManagementDiscounts hotelManagementDiscounts) {
        return hotelManagementDiscounts;
    }

    public void HotelManagementDiscounts(HotelManagementDiscounts hotelManagementDiscounts) {
        this.hotelManagementDiscounts=hotelManagementDiscounts;
    }

    public long getBookingId() {
        return bookingId;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getGuestAddress() {
        return guestAddress;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public byte[] getIdentityProof() {
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
        this.creationDate=creationDate;
    }
    
    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated=lastUpdated;
    }
    
    public void setLocationName(String locationName) {
        this.locationName=locationName;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress=guestAddress;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus=bookingStatus;
    }

    public void setIdentityProof(byte[] identityProof) {
        this.identityProof=identityProof;
    }

    public void setToDate(Date toDate) {
        this.toDate=toDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate=fromDate;
    }

    @Override
    public String toString() {
	    return "Reservation [bookingId=" + bookingId +  ", locationName=" + locationName +
                            ", guestAddress=" + guestAddress + ", bookingStatus=" + bookingStatus + 
                            //", identificationProof=" + identificationProof + 
                            ", toDate=" + toDate + ", fromDate=" + fromDate + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}