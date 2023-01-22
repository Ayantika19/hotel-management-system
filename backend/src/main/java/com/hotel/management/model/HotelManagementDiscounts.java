// package com.hotel.management.model;

// import javax.persistence.Entity;
// import javax.persistence.Table;
// import javax.persistence.Id;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Column;

// import java.util.Date;

// import com.fasterxml.jackson.annotation.JsonFormat;

// @Entity
// @Table(name = "Discounts")
// public class HotelManagementDiscounts {
//     @Id
//     @GeneratedValue
//     private long registrationId;

//     @Id
//     @GeneratedValue
//     private long discountId;

//     @Column(name="LocationID") // get it from location table
//     private long locationID;

//     @Column(name="HotelID") // get it from location table
//     private long hotelID;

//     @Column(name="CompanyName")
//     private String companyName;

//     @Column(name="CompanyAddress")
//     private String companyAddress;

//     @Column(name="EmailID")
//     private String emailID;

//     @Column(name="ContactNumber")
//     private int contactNumber;

//     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
//     @Column(name="creationDate")
//     private Date creationDate;

//     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
//     @Column(name="lastUpdated")
//     private Date lastUpdated;

//     public HotelManagementDiscounts() {

//     }

//     public HotelManagementDiscounts(long locationID, long hotelID, String companyName, String companyAddress, String emailID, int contactNumber) {
//         this.locationID=locationID;
//         this.hotelID=hotelID;
//         this.companyName=companyName;
//         this.companyAddress=companyAddress;
//         this.emailID=emailID;
//         this.contactNumber=contactNumber;
//     }
    
//     public long getRegistrationId() {
//         return registrationId;
//     }

//     public long getDiscountId() {
//         return discountId;
//     }

//     public long getHotelId() {
//         return hotelID;
//     }

//     public long getLocationId() {
//         return locationID;
//     }

//     public String getCompanyName() {
//         return companyName;
//     }

//     public String getCompanyAddress() {
//         return companyAddress;
//     }

//     public String getEmailID() {
//         return emailID;
//     }

//     public int getContactNumber() {
//         return contactNumber;
//     }

//     public Date getcreationDate() {
//         return creationDate;
//     }
    
//     public Date getlastUpdated() {
//         return lastUpdated;
//     }

//     public void setLocationID(long locationID) {
//         this.locationID=locationID;
//     }
    
//     public void setCompanyName(String companyName) {
//         this.companyName=companyName;
//     } 

//     public void setCompanyAddress(String companyAddress) {
//         this.companyAddress=companyAddress;
//     }

//     public void setContactNumber(int contactNumber) {
//         this.contactNumber=contactNumber;
//     }

//     public void setHotelID(long hotelID) {
//         this.hotelID=hotelID;
//     }

//     public void setEmailID(String emailID) {
//         this.emailID=emailID;
//     }

//     public void setcreationDate(Date creationDate) {
//         this.creationDate=creationDate;
//     }
    
//     public void setlastUpdated(Date lastUpdated) {
//         this.lastUpdated=lastUpdated;
//     }

//     @Override
//     public String toString() {
// 	    return "Discounts [registrationId=" + registrationId + ", discountId=" + discountId + ", locationId=" + locationID + ", companyName=" + companyName + ", hotelID=" + hotelID + ", companyName=" + companyName + ", companyAddress=" + companyAddress + ", emailID=" + emailID + ", contactNumber=" + contactNumber + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
//     }    
// }