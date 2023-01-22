package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
// import javax.swing.JFrame;
// import javax.swing.JPanel;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

// import java.awt.image.BufferedImage;

@Entity
@Table(name = "Reservation")
public class HotelManagementReservation {
    @Id
    @GeneratedValue
    private long bookingId;   
    
    @OneToOne
    @JoinColumn(name="GuestID",referencedColumnName="GuestID")
    private HotelManagementGuestRegistration hotelManagementGuestRegistration;

    @Column(name="HotelID")
    private long hotelId;

    @Column(name="RoomID")
    private long roomId;

    @Column(name="DiscountID")
    private long discountId;

    @Column(name="LocationName")
    private String locationName;

    @Column(name="Address")
    private String guestAddress;

    @Column(name="BookingStatus")
    private String bookingStatus;

    @Column(name="RoomCharges")
    private double roomCharges;

    // @Column(name="IdentificationProof")
    // private BufferedImage identificationProof;

    @Temporal(TemporalType.DATE)
    @Column(name="ToDate")
    private Date toDate;

    @Temporal(TemporalType.DATE)
    @Column(name="FromDate")
    private Date fromDate;

    @CreationTimestamp
    @Column(name="creationDate")
    private Timestamp creationDate;

    @UpdateTimestamp
    @Column(name="lastUpdated")
    private Timestamp lastUpdated;

    public HotelManagementReservation() {

    }

    public HotelManagementReservation(long hotelId, long roomId, long discountId, String locationName, String guestAddress, 
                                        String bookingStatus, double roomCharges, Date toDate, Date fromDate) {
        // this.guestId=guestId;
        this.hotelId=hotelId;
        this.roomId=roomId;
        this.discountId=discountId;
        this.locationName=locationName;
        this.guestAddress=guestAddress;
        this.bookingStatus=bookingStatus;
        this.roomCharges=roomCharges;
        // this.identificationProof=identificationProof;
        this.toDate=toDate;
        this.fromDate=fromDate;                                   
    }
    
    public HotelManagementGuestRegistration getHotelManagementGuestRegistration() {
        return hotelManagementGuestRegistration;
    }

    public void setHotelManagementGuestRegistration(HotelManagementGuestRegistration hotelManagementGuestRegistration) {
        this.hotelManagementGuestRegistration=hotelManagementGuestRegistration;
    }

    public long getBookingId() {
        return bookingId;
    }

    // public long getGuestId() {
    //     return guestId;
    // }

    public long getHotelId() {
        return hotelId;
    }

    public long getRoomId() {
        return roomId;
    }

    public long getDiscountId() {
        return discountId;
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

    public double getRoomCharges() {
        return roomCharges;
    }

    // public BufferedImage getIdentificationProof() {
    //     return identificationProof;
    // }

    public Date getToDate() {
        return toDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Timestamp getcreationDate() {
        return creationDate;
    }
    
    public Timestamp getlastUpdated() {
        return lastUpdated;
    }

    public void setcreationDate(Timestamp creationDate) {
        this.creationDate=creationDate;
    }
    
    public void setlastUpdated(Timestamp lastUpdated) {
        this.lastUpdated=lastUpdated;
    }
    
    public void setHotelId(long hotelId) {
        this.hotelId=hotelId;
    }

    public void setRoomId(long roomId) {
        this.roomId=roomId;
    }

    public void setDiscountId(long discountId) {
        this.discountId=discountId;
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

    public void setRoomCharges(double roomCharges) {
        this.roomCharges=roomCharges;
    }

    // public void setIdentificationProof(BufferedImage identificationProof) {
    //     this.identificationProof=identificationProof;
    // }

    public void setToDate(Date toDate) {
        this.toDate=toDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate=fromDate;
    }

    @Override
    public String toString() {
	    return "Reservation [bookingId=" + bookingId +  ", hotelId=" + hotelId + 
                            ", roomId=" + roomId + ", discountId=" + discountId + ", locationName=" + locationName +
                            ", guestAddress=" + guestAddress + ", bookingStatus=" + bookingStatus + 
                            ", roomCharges=" + roomCharges + 
                            //", identificationProof=" + identificationProof + 
                            ", toDate=" + toDate + ", fromDate=" + fromDate + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}