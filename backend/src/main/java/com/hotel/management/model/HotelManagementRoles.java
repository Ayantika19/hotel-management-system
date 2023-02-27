package com.hotel.management.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Column;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "roles")
@EntityListeners(AuditingEntityListener.class)
public class HotelManagementRoles {

    @Id
    @SequenceGenerator(name = "roles_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
    @Column(name = "roleid")
    private long roleId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rolesandprivileges", joinColumns = @JoinColumn(name = "roleid", referencedColumnName = "roleid"), inverseJoinColumns = @JoinColumn(name = "privilegeid", referencedColumnName = "privilegeid"))
    private Collection<HotelManagementPrivileges> hotelManagementPrivileges;

    @Column(name = "rolename", unique = true, nullable = false)
    private String rolename;

    @CreatedDate
    @Column(name = "creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name = "lastupdated")
    private Date lastUpdated;

    public HotelManagementRoles() {

    }

    public HotelManagementRoles(String rolename, Date creationDate, Date lastUpdated) {
        this.rolename = rolename;
        this.creationDate = creationDate;
        this.lastUpdated = lastUpdated;
    }

    public Collection<HotelManagementPrivileges> getHotelManagementPrivileges() {
        return hotelManagementPrivileges;
    }

    public void setHotelManagementPrivileges(Collection<HotelManagementPrivileges> hotelManagementPrivileges) {
        this.hotelManagementPrivileges = hotelManagementPrivileges;
    }

    public long getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return rolename;
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

    public void setRoleName(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Roles [roleId=" + roleId + ", rolename=" + rolename + ", creationDate=" + creationDate
                + ", lastUpdated=" + lastUpdated + "]";
    }
}