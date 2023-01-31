package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToMany;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityListeners;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "discounts")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementDiscounts {

    @Id
    @GeneratedValue
    @Column(name="discountid")
    private long discountId;

    @ManyToMany(mappedBy = "hotelManagementDiscounts")
    private Collection<HotelManagementHotelDetails> hotelManagementHotelDetails;

    @Column(name="companyname", nullable = false)
    private String companyName;

    @Column(name="companyaddress")
    private HotelManagementAddress companyAddress;

    @Column(name="emailid")
    private String emailID;

    @Column(name="contactnumber", nullable = false)
    private HotelManagementContactNumber contactNumber;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated", nullable = false)
    private Date lastUpdated;

    public HotelManagementDiscounts() {

    }

    public HotelManagementDiscounts(String companyName, HotelManagementAddress companyAddress, String emailID, HotelManagementContactNumber contactNumber) {
        
        this.companyName=companyName;
        this.companyAddress=companyAddress;
        this.emailID=emailID;
        this.contactNumber=contactNumber;
    }

    public Collection<HotelManagementHotelDetails> getHotelManagementHotelDetails() {
        return hotelManagementHotelDetails;
    }

    public void setHotelManagementHotelDetails(Collection<HotelManagementHotelDetails> hotelManagementHotelDetails) {
        this.hotelManagementHotelDetails=hotelManagementHotelDetails;
    }
    
    public long getDiscountId() {
        return discountId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public HotelManagementAddress getCompanyAddress() {
        return companyAddress;
    }

    public String getEmailID() {
        return emailID;
    }

    public HotelManagementContactNumber getContactNumber() {
        return contactNumber;
    }

    public Date getcreationDate() {
        return creationDate;
    }
    
    public Date getlastUpdated() {
        return lastUpdated;
    }
   
    public void setCompanyName(String companyName) {
        this.companyName=companyName;
    } 

    public void setCompanyAddress(HotelManagementAddress companyAddress) {
        this.companyAddress=companyAddress;
    }

    public void setContactNumber(HotelManagementContactNumber contactNumber) {
        this.contactNumber=contactNumber;
    }

    public void setEmailID(String emailID) {
        this.emailID=emailID;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate=creationDate;
    }
    
    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated=lastUpdated;
    }

    @Override
    public String toString() {
	    return "Discounts [discountId=" + discountId + ", companyName=" + companyName + ", companyAddress=" + companyAddress + ", emailID=" + emailID + ", contactNumber=" + contactNumber + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }    
}