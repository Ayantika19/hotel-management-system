package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Permissions")
public class HotelManagementPermissions {
    @Id
    @GeneratedValue
    private long permissionID;

    @Column(name="roleID")
    private long roleID;

    @Column(name="permissionModule")
    private String permissionModule;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="creationDate")
    private Date creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column(name="lastUpdated")
    private Date lastUpdated;

    public HotelManagementPermissions() {

    }

    public HotelManagementPermissions(long roleID, String permissionModule, Date creationDate, Date lastUpdated) {
        this.roleID=roleID;
        this.permissionModule=permissionModule;
        this.creationDate=creationDate;
        this.lastUpdated=lastUpdated;
    }

    public long getPermissionID(long permissionID) {
        return permissionID;
    }

    public long getRoleID(long roleID) {
        return roleID;
    }

    public String getPermissionModule(String permissionModule) {
        return permissionModule;
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

    public void setPermissionModule(String permissionModule) {
        this.permissionModule=permissionModule;
    }

    public void setRoleID(long roleID) {
        this.roleID=roleID;
    }

    @Override
    public String toString() {
	    return "Permissions [permissionID=" + permissionID + "roleID=" + roleID + ", permissionModule=" + permissionModule + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}
