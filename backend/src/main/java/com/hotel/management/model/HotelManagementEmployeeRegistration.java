package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.EntityListeners;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementEmployeeRegistration {

    @Id
    @SequenceGenerator(name = "employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @Column(name = "employeeid")
    private long employeeId;

    @ManyToOne
    @JoinColumn(name = "locationid", referencedColumnName = "locationid")
    private HotelManagementLocation hotelManagementLocation;

    @ManyToOne
    @JoinColumn (name = "roleid")
    private HotelManagementRoles hotelManagementRoles;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "emailid", unique = true, nullable = false)
    private String emailID;

    @Column(name = "password", nullable = false)
    private char[] password;

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

    @Temporal(TemporalType.DATE)
    @Column(name = "dob", nullable = false)
    private Date dateOfBirth;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    public HotelManagementEmployeeRegistration() {

    }

    public HotelManagementEmployeeRegistration(String firstName, String lastName, String emailID,
            char[] password, int houseNumber, String street, String city, long pincode,
            String countrycode, long number, Date dateOfBirth,
            Date creationDate, Date lastUpdated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.password = password;
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.countrycode = countrycode;
        this.number = number;
        this.dateOfBirth = dateOfBirth;
        this.creationDate = creationDate;
        this.lastUpdated = lastUpdated;
    }

    public HotelManagementLocation getHotelManagementLocation() {
        return hotelManagementLocation;
    }

    public void setHotelManagementHotelFacilities(HotelManagementLocation hotelManagementLocation) {
        this.hotelManagementLocation = hotelManagementLocation;
    }

    public HotelManagementRoles getHotelManagementRoles() {
        return hotelManagementRoles;
    }

    public void setHotelManagementRoles(HotelManagementRoles hotelManagementRoles) {
        this.hotelManagementRoles = hotelManagementRoles;
    }

    public long getEmployeeId() {
        return employeeId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
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

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", emailID=" + emailID + ", password=" + password.toString() +
                ", houseNumber=" + houseNumber + ", street=" + street + ", city=" + city + ", pincode=" + pincode
                + ", countrycode=" + countrycode +
                ", number=" + number + ", DOB=" + dateOfBirth + ", creationDate=" + creationDate + ", lastUpdated="
                + lastUpdated + "]";
    }
}