package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementUser {
    
    
    @Id
    @Column(name = "userid")
    @GeneratedValue
    private long userId;

    @Column(name="firstname", nullable = false)
    private String firstName;

    @Column(name="lastname", nullable = false)
    private String lastName;

    @Column(name="emailid", nullable = false)
    private String emailID;

    @Column(name="password", nullable = false)
    private char[] password;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated", nullable = false)
    private Date lastUpdated;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="roles", joinColumns = @JoinColumn(name="userid",referencedColumnName = "userid"), inverseJoinColumns = @JoinColumn(name="roleid", referencedColumnName = "roleid"))
    private Collection<HotelManagementRoles> hotelManagementRoles;

    public HotelManagementUser() {

    }

    public HotelManagementUser(String firstName, String lastName, String emailID, char[] password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.emailID=emailID;
        this.password=password;
    }

    public long getUserId() {
        return userId;
    }

    public String getfirstname () {
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

    
    public Collection<HotelManagementRoles> getHotelManagementRoles() {
        return hotelManagementRoles;
    }

    public void setHotelManagementRoles(Collection<HotelManagementRoles> hotelManagementRoles) {
        this.hotelManagementRoles = hotelManagementRoles;
    }
    
    public void setcreationDate(Date creationDate) {
        this.creationDate=creationDate;
    }
    
    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated=lastUpdated;
    }

    public void setfirstname(String firstName) {
        this.firstName=firstName;
    }

    public void setlastname(String lastName) {
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
	    return "User[userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + 
                        ", emailID=" + emailID + ", password=" + password.toString() +  
                        ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }

}