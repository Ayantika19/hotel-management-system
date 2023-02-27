package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.FetchType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "privileges")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementPrivileges {

    @Id
    @SequenceGenerator(name = "privilege_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "privilege_seq")
    @Column(name = "privilegeid")
    private long privilegeId;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "hotelManagementPrivileges")
    @JsonIgnore
    private Collection<HotelManagementRoles> hotelManagementRoles;

    @Column(name = "privilegemodule", unique = true, nullable = false)
    private String privilegemodule;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    public HotelManagementPrivileges() {

    }

    public HotelManagementPrivileges(String privilegemodule) {

        this.privilegemodule = privilegemodule;
    }

    public Collection<HotelManagementRoles> getHotelManagementRoles() {
        return hotelManagementRoles;
    }

    public void setHotelManagementRoles(Collection<HotelManagementRoles> hotelManagementRoles) {
        this.hotelManagementRoles = hotelManagementRoles;
    }

    public long getPrivilegeId() {
        return privilegeId;
    }

    public String getPrivilegeModule() {
        return privilegemodule;
    }

    public Date getcreationDate() {
        return creationDate;
    }

    public Date getlastUpdated() {
        return lastUpdated;
    }

    public void setPrivilegeModule(String privilegemodule) {
        this.privilegemodule = privilegemodule;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setlastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Privileges [privilegeId=" + privilegeId + ", privilegeModule=" + privilegemodule +  ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}