package edu.iss.ca.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Time Slot
 * 
 */

@Entity
@Table(name = "timeslots")
public class TimeSlot {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "timeslotid")
    private int id;
	
	@Column(name = "timeslot")
	private String timeslot;

//	@OneToMany(mappedBy="timeslot", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	private List<Booking> bookinglist = new ArrayList<Booking>();
	
	@OneToMany(mappedBy="timeslot", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Maintenance> maintenancelist = new ArrayList<Maintenance>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}

//	public TimeSlot(int id, String timeslot) {
//		super();
//		this.id = id;
//		this.timeslot = timeslot;
//	}
//	
//	public TimeSlot() {
//	}	

}
