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
    @GeneratedValue
    @Column(name="roleid")
    private long roleId;

    @Column(name="rolename")
    private String roleName;

    @ManyToMany(mappedBy = "hotelManagementRoles")
    private Collection<HotelManagementEmployeeRegistration> hotelManagementEmployeeRegistration;

    @ManyToMany(mappedBy = "hotelManagementRoles")
    private Collection<HotelManagementGuestRegistration> hotelManagementGuestRegistration;

    @ManyToMany
    @JoinTable(name = "rolesandprivileges", joinColumns = @JoinColumn(name = "roleid", referencedColumnName = "roleid"), inverseJoinColumns = @JoinColumn(name = "privilegeid", referencedColumnName = "privilegeid"))
    private Collection<HotelManagementPrivileges> hotelManagementPrivileges;

    @CreatedDate
    @Column(name="creationdate")
    private Date creationDate;

    @LastModifiedDate
    @Column(name="lastupdated")
    private Date lastUpdated;

    public HotelManagementRoles() {

    }

    public HotelManagementRoles(String roleName, Date creationDate, Date lastUpdated) {
        this.roleName=roleName;
        this.creationDate=creationDate;
        this.lastUpdated=lastUpdated;
    }

    public long getRoleID(long roleId) {
        return roleId;
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

    public Collection<HotelManagementEmployeeRegistration> getHotelManagementEmployeeRegistration() {
        return hotelManagementEmployeeRegistration;
    }

    public void setHotelManagementEmployeeRegistration(Collection<HotelManagementEmployeeRegistration> hotelManagementEmployeeRegistration) {
        this.hotelManagementEmployeeRegistration = hotelManagementEmployeeRegistration;
    }

    public Collection<HotelManagementGuestRegistration> getHotelManagementGuestRegistration() {
        return hotelManagementGuestRegistration;
    }

    public void setHotelManagementGuestRegistration(Collection<HotelManagementGuestRegistration> hotelManagementGuestRegistration) {
        this.hotelManagementGuestRegistration = hotelManagementGuestRegistration;
    }

    public Collection<HotelManagementPrivileges> getHotelManagementPrivileges() {
        return hotelManagementPrivileges;
    }

    public void setHotelManagementPrivileges(Collection<HotelManagementPrivileges> hotelManagementPrivileges) {
        this.hotelManagementPrivileges = hotelManagementPrivileges;
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
	    return "Roles [roleId=" + roleId + ", roleName=" + roleName + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated + "]";
    }
}
