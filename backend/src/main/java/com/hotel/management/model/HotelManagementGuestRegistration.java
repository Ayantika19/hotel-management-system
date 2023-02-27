package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.EntityListeners;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "guest")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementGuestRegistration {
    @Id
    @SequenceGenerator(name = "guest_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_seq")
    @Column(name = "guestid")
    private long guestId;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "emailid", unique = true, nullable = false)
    private String emailID;

    @Column(name = "password", nullable = false)
    private char[] password;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn (name = "roleid")
    private HotelManagementRoles hotelManagementRoles;

    public HotelManagementGuestRegistration() {

    }

    public HotelManagementGuestRegistration(String firstName, String lastName, String emailID, char[] password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.password = password;
    }

    public HotelManagementRoles getHotelManagementRoles() {
        return hotelManagementRoles;
    }

    public void setHotelManagementRoles(HotelManagementRoles hotelManagementRoles) { //set default 
        this.hotelManagementRoles = hotelManagementRoles;
    }

    public long getGuestId() {
        return guestId;
    }

    public String getfirstname() {
        return firstName;
    }

    public String getlastname() {
        return lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public char[] getPassword() {
        return password;
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

    public void setfirstname(String firstName) {
        this.firstName = firstName;
    }

    public void setlastname(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Guest[guestId=" + guestId + ", firstName=" + firstName + ", lastName=" + lastName +
                ", emailID=" + emailID + ", password=" + password.toString() +
                ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}
