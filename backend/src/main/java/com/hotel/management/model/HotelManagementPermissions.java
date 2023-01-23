package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.EntityListeners;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "permissions")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementPermissions {
    @Id
    @GeneratedValue
    @Column(name="permissionid")
    private long permissionId;

    @Column(name="permissionmodule")
    private String permissionModule;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated")
    private Date lastUpdated;

    public HotelManagementPermissions() {

    }

    public HotelManagementPermissions(String permissionModule, Date creationDate, Date lastUpdated) {
        this.permissionModule=permissionModule;
        this.creationDate=creationDate;
        this.lastUpdated=lastUpdated;
    }

    public long getPermissionID(long permissionId) {
        return permissionId;
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

    @Override
    public String toString() {
	    return "Permissions [permissionId=" + permissionId + ", permissionModule=" + permissionModule + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}
