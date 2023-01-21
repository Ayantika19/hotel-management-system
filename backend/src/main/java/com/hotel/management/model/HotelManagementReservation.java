// package com.hotel.management.model;

// import javax.persistence.Entity;
// import javax.persistence.Table;
// import javax.persistence.Id;
// import javax.persistence.GeneratedValue;
// import javax.management.openmbean.CompositeData;
// import javax.persistence.Column;

// @Entity
// @Table(name = "Reservation")

// public class HotelManagementReservation {
//     @Id
//     @GeneratedValue
//     private long bookingId;

//     @Column(name="locationName")
//     private String locationName;

// public HotelManagementLocation() {

// }
// public HotelManagementLocation(String locationName) {
//     this.locationName=locationName;
// }

// public long getLocationId() {
//     return locationId;
// }

// public String getLocationName() {
//     return locationName;
// }

// public void setLocationName(String locationName) {
//     this.locationName=locationName;
// }

// @Override
// public String toString() {
// 	return "Location [locationId=" + locationId + ", locationName=" + locationName
// }
// }

// //foreign key declaration in java?
// @Entity
// @Table(name="takeCourse")
// public class TakeCourse implements Serializable {


//     @EmbeddedId 
//     private CompositeData id;

//     @MapsId    
//     @ManyToOne
//     @JoinColumn(name = "sid")
//     private Student student;

//     @MapsId        
//     @ManyToOne
//     @JoinColumn(name = "cid")
//     private Course course;

//     // getters and setters
// }


