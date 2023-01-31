package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementEmployeeRegistration {

    @Id
    @GeneratedValue
    @Column(name="employeeid")
    private long employeeId;

    @ManyToOne 
    @JoinColumn(name="locationid",referencedColumnName="locationid", nullable = false)
    private HotelManagementLocation hotelManagementLocation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="employeesroles", joinColumns = @JoinColumn(name="employeeid",referencedColumnName = "employeeid"), inverseJoinColumns = @JoinColumn(name="roleid", referencedColumnName = "roleid"))
    private Collection<HotelManagementRoles> hotelManagementRoles;

    @Column(name="firstname", nullable = false)
    private String firstName;

    @Column(name="lastname", nullable = false)
    private String lastName;

    @Column(name="emailid", nullable = false)
    private String emailID;

    @Column(name="password", nullable = false)
    private char[] password;

    @Column(name="contactnumber", nullable = false)
    private HotelManagementContactNumber employeeContactNumber;

    @Column(name="address")
    private HotelManagementAddress employeeAddress;

    @Temporal(TemporalType.DATE)
    @Column(name="dob")
    private Date dateOfBirth;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated", nullable = false)
    private Date lastUpdated;
    
    public HotelManagementEmployeeRegistration() {

    }

    public HotelManagementEmployeeRegistration(String firstName, String lastName, String emailID,
                                                char[] password, HotelManagementContactNumber employeeContactNumber, HotelManagementAddress employeeAddress, Date dateOfBirth, 
                                                Date creationDate, Date lastUpdated) {
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
    
    public HotelManagementLocation getHotelManagementLocation() {
        return hotelManagementLocation;
    }

    public void setHotelManagementHotelFacilities(HotelManagementLocation hotelManagementLocation) {
        this.hotelManagementLocation=hotelManagementLocation;
    }

    public Collection<HotelManagementRoles> getHotelManagementRoles() {
        return hotelManagementRoles;
    }

    public void setHotelManagementRoles(Collection<HotelManagementRoles> hotelManagementRoles) {
        this.hotelManagementRoles = hotelManagementRoles;
    }

    public long getEmployeeId() {
        return employeeId;
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

    public HotelManagementContactNumber getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public HotelManagementAddress getEmployeeAddress() {
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

    public void setEmployeeContactNumber(HotelManagementContactNumber employeeContactNumber) {
        this.employeeContactNumber=employeeContactNumber;
    }

    public void setemployeeAddress(HotelManagementAddress employeeAddress) {
        this.employeeAddress=employeeAddress;
    }

    public void setDOB(Date dateOfBirth) {
        this.dateOfBirth=dateOfBirth;
    }

    @Override
    public String toString() {
	    return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailID=" + emailID + ", password=" + password.toString() + 
                          ", contactNumber=" + employeeContactNumber + ", address=" + employeeAddress + ", DOB=" + dateOfBirth + 
                          ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }    
}