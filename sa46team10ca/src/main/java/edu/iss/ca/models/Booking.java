package edu.iss.ca.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="booking")
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingid")
	private int bookingid;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "facilityid")
	private Facility facility;
	
	@ManyToOne
	@JoinColumn(name = "timeslotid")
	private TimeSlot timeslot;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	
	@Column(name = "status")
	private String status;
	
	public Booking() {
	}	

	public Booking(int bookingid, User user, Facility facility, TimeSlot timeslot, Date date, String status) {
		super();
		this.bookingid = bookingid;
		this.user = user;
		this.facility = facility;
		this.timeslot = timeslot;
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
		return user;
	}

	public void setUserid(User userid) {
		this.user = userid;
	}

	public Facility getFacilityid() {
		return facility;
	}

	public void setFacilityid(Facility facilityid) {
		this.facility = facilityid;
	}

	public TimeSlot getTimeslotid() {
		return timeslot;
	}

	public void setTimeslotid(TimeSlot timeslotid) {
		this.timeslot = timeslotid;
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
