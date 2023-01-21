package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Roles")
public class HotelManagementRoles {
    @Id
    @GeneratedValue
    private long roleID;

    @Column(name="roleName")
    private String roleName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="creationDate")
    private Date creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="lastUpdated")
    private Date lastUpdated;

    public HotelManagementRoles() {

    }

    public HotelManagementRoles(String roleName, Date creationDate, Date lastUpdated) {
        this.roleName=roleName;
        this.creationDate=creationDate;
        this.lastUpdated=lastUpdated;
    }

    public long getRoleID(long roleID) {
        return roleID;
    }

    public String getRoleName(String roleName) {
        return roleName;
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

    public void setRoleName(String roleName) {
        this.roleName=roleName;
    }

    @Override
    public String toString() {
	    return "Roles [roleID=" + roleID + ", roleName=" + roleName + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}
