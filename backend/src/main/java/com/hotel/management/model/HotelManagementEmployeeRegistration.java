package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Employee")
public class HotelManagementEmployeeRegistration {
    @Id
    @GeneratedValue
    private long registrationId;

    @Id
    @GeneratedValue
    private long employeeId;

    @Column(name="LocationID")
    private long locationId;

    @Column(name="HotelID")
    private long hotelId;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="EmailID")
    private String emailID;

    @Column(name="Password")
    private char[] password;

    @Column(name="ContactNumber")
    private int employeeContactNumber;

    @Column(name="Address")
    private String employeeAddress;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="DOB")
    private Date dateOfBirth;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="creationDate")
    private Date creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="lastUpdated")
    private Date lastUpdated;

    public HotelManagementEmployeeRegistration() {

    }

    public HotelManagementEmployeeRegistration(long locationId, long hotelId, String firstName, String lastName, String emailID,
                                                char[] password, int employeeContactNumber, String employeeAddress, Date dateOfBirth, 
                                                Date creationDate, Date lastUpdated) {
        this.locationId=locationId;
        this.hotelId=hotelId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.emailID=emailID;
        this.password=password;
        this.employeeContactNumber=employeeContactNumber;
        this.employeeAddress=employeeAddress;
        this.dateOfBirth=dateOfBirth;
        this.creationDate=creationDate;
        this.lastUpdated=lastUpdated;
    }
    
    public long getRegistrationId() {
        return registrationId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public long getLocationId() {
        return locationId;
    }

    public long getHotelId() {
        return hotelId;
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

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public Date getEmployeeDOB() {
        return dateOfBirth;
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

    public void setLocationId(long locationId) {
        this.locationId=locationId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId=hotelId;
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

    public void setEmployeeContactNumber(int employeeContactNumber) {
        this.employeeContactNumber=employeeContactNumber;
    }

    public void setemployeeAddress(String employeeAddress) {
        this.employeeAddress=employeeAddress;
    }

    public void setDOB(Date dateOfBirth) {
        this.dateOfBirth=dateOfBirth;
    }

    @Override
    public String toString() {
	    return "Employee [registrationId=" + registrationId + ", employeeId=" + employeeId + ", locationId=" + locationId + ", hotelId=" + hotelId + 
                          ", firstName=" + firstName + ", lastName=" + lastName + ", emailID=" + emailID + ", password=" + password + 
                          ", contactNumber=" + employeeContactNumber + ", address=" + employeeAddress + ", DOB=" + dateOfBirth + 
                          ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }    
}