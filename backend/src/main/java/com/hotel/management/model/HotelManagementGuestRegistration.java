package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Guest")
public class HotelManagementGuestRegistration {
    @Id
    @GeneratedValue
    @Column(name="GuestID")
    private long guestId;  

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="EmailID")
    private String emailID;

    @Column(name="Password")
    private char[] password;

    @CreationTimestamp
    @Column(name="creationDate")
    private Timestamp creationDate;

    @UpdateTimestamp
    @Column(name="lastUpdated")
    private Timestamp lastUpdated;

    public HotelManagementGuestRegistration() {

    }

    public HotelManagementGuestRegistration(String firstName, String lastName, String emailID, char[] password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.emailID=emailID;
        this.password=password;
        // this.creationDate=creationDate;
        // this.lastUpdated=lastUpdated;
    }

    public long getGuestId() {
        return guestId;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public char[] getPassword() {
        return password;
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

    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
    }

    public void setEmailID(String emailID) {
        this.emailID=emailID;
    }

    public void setPassword(char[] password) {
        this.password=password;
    }

    @Override
    public String toString() {
	    return "Guest[guestId=" + guestId + ", firstName=" + firstName + 
                          ", lastName=" + lastName + ", emailID=" + emailID + ", password=" + password + "]"; 
                        //   ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + 
    }
}    

