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

import org.springframework.format.annotation.DateTimeFormat;


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
	@DateTimeFormat(pattern= "dd/MM/yyyy" )
	@Column(name = "date")
	private Date date;
	
	@Column(name = "bookingstatus")
	private String status;
	
	public Booking() {
		super();
		this.date = new Date();
		this.status = "ACTIVE";
	}	

	public Booking(User user, Facility facility, TimeSlot timeslot, String status) {
		super();
		
		this.user = user;
		this.facility = facility;
		this.timeslot = timeslot;
		this.status = status;
	}
	
	public Booking(User user, Facility facility, TimeSlot timeslot, Date date, String status) {
		super();


		this.user = user;
		this.facility = facility;
		this.timeslot = timeslot;
		this.date = date;
		this.status = status;
	}

	public Facility getFacility() {
		return facility;
	}

	public TimeSlot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(TimeSlot timeslot) {
		this.timeslot = timeslot;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
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
