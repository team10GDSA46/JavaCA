package edu.iss.ca.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="booking")
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingid")
	private int bookingid;
	
	@Column(name = "userid")
	private User userid;
	
	@Column(name = "facilityid")
	private Facility facilityid;
	
	@Column(name = "timeslot")
	private TimeSlot timeslotid;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "bookingcol")
	private String status;
	
	public Booking() {
	}	

	public Booking(int bookingid, User userid, Facility facilityid, TimeSlot timeslotid, Date date, String status) {
		super();
		this.bookingid = bookingid;
		this.userid = userid;
		this.facilityid = facilityid;
		this.timeslotid = timeslotid;
		this.date = date;
		this.status = status;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public Facility getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(Facility facilityid) {
		this.facilityid = facilityid;
	}

	public TimeSlot getTimeslotid() {
		return timeslotid;
	}

	public void setTimeslotid(TimeSlot timeslotid) {
		this.timeslotid = timeslotid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
