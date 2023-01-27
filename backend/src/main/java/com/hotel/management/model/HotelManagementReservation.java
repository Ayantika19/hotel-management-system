package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import java.util.Date;
import java.util.Set;

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
    @JoinColumn(name="guestid",referencedColumnName="guestid", nullable = false)
    private HotelManagementGuestRegistration hotelManagementGuestRegistration;

    @ManyToOne
    @JoinColumn(name="hotelid",referencedColumnName="hotelid", nullable = false)
    private HotelManagementHotelFacilities hotelManagementHotelFacilities;

    @OneToMany(mappedBy = "hotelManagementReservation")
    private Set<HotelManagementRooms> hotelManagementRooms;

    @OneToOne
    @JoinColumn(name="discountid",referencedColumnName="discountid")
    private HotelManagementDiscounts hotelManagementDiscounts;

    @Column(name="address", nullable = false)
    private HotelManagementAddress guestAddress;

    @Column(name = "contactnumber", nullable = false)
    private HotelManagementContactNumber guestContactNumber;

    @Column(name="bookingstatus")
    private String bookingStatus;

    @Lob @Basic(fetch = FetchType.LAZY)
	@Column(name="identityproof",columnDefinition="BLOB") 
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
    @Column(name="lastupdated", nullable = false)
    private Date lastUpdated;

    public HotelManagementReservation() {

    }

    public HotelManagementReservation( HotelManagementAddress guestAddress, HotelManagementContactNumber guestContactNumber, String bookingStatus, Date toDate, Date fromDate, byte[] identityProof) {
        
        this.guestAddress=guestAddress;
        this.bookingStatus=bookingStatus;
        this.guestContactNumber=guestContactNumber;
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

    public void setHotelManagementRooms(Set<HotelManagementRooms> hotelManagementRooms) {
        this.hotelManagementRooms = hotelManagementRooms;
    }

    public HotelManagementDiscounts gethotelManagementDiscounts(HotelManagementDiscounts hotelManagementDiscounts) {
        return hotelManagementDiscounts;
    }

    public void HotelManagementDiscounts(HotelManagementDiscounts hotelManagementDiscounts) {
        this.hotelManagementDiscounts=hotelManagementDiscounts;
    }

    public long getBookingId() {
        return bookingId;
    }

    public HotelManagementAddress getGuestAddress() {
        return guestAddress;
    }

    public HotelManagementContactNumber getGuestContactNumber() {
        return guestContactNumber;
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

    public void setGuestAddress(HotelManagementAddress guestAddress) {
        this.guestAddress=guestAddress;
    }

    public void setGuestContactNumber(HotelManagementContactNumber guestContactNumber) {
        this.guestContactNumber=guestContactNumber;
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
	    return "Reservation [bookingId=" + bookingId + ", guestAddress=" + guestAddress + ", bookingStatus=" + bookingStatus + 
                            ", identityProof=" + identityProof + 
                            ", toDate=" + toDate + ", fromDate=" + fromDate + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}
