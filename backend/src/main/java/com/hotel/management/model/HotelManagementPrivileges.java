package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "privileges")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementPrivileges {
    @Id
    @GeneratedValue
    @Column(name="privilegeid")
    private long privilegeId;

    @Column(name="privilegemodule")
    private String privilegeModule;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @ManyToMany(mappedBy = "hotelManagementPrivileges")
    private Collection<HotelManagementRoles> hotelManagementRoles;

    @LastModifiedDate
    @Column(name="lastupdated")
    private Date lastUpdated;

    public HotelManagementPrivileges() {

    }

    public HotelManagementPrivileges(String privilegeModule, Date creationDate, Date lastUpdated) {
        this.privilegeModule=privilegeModule;
        this.creationDate=creationDate;
        this.lastUpdated=lastUpdated;
    }

    public long getprivilegeID(long privilegeId) {
        return privilegeId;
    }

    public String getprivilegeModule(String privilegeModule) {
        return privilegeModule;
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

    public void setprivilegeModule(String privilegeModule) {
        this.privilegeModule=privilegeModule;
    }

    public Collection<HotelManagementRoles> getHotelManagementRoles() {
        return hotelManagementRoles;
    }

    public void setHotelManagementRoles(Collection<HotelManagementRoles> hotelManagementRoles) {
        this.hotelManagementRoles = hotelManagementRoles;
    }
    
    @Override
    public String toString() {
	    return "privileges [privilegeId=" + privilegeId + ", privilegeModule=" + privilegeModule + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}
