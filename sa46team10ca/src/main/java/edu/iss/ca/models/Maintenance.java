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
@Table(name="maintenance")
public class Maintenance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maintenanceid")
	private int maintenanceid;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "facilityid")
	private Facility facility;
	
	@ManyToOne
	@JoinColumn(name = "timeslotid")
	private TimeSlot timeslot;
	
	public Maintenance() {
	}

	public Maintenance(int maintenanceid, Date date, Facility facility, TimeSlot timeslot) {
		super();
		this.maintenanceid = maintenanceid;
		this.date = date;
		this.facility = facility;
		this.timeslot = timeslot;
	}

	public int getMaintenanceid() {
		return maintenanceid;
	}

	public void setMaintenanceid(int maintenanceid) {
		this.maintenanceid = maintenanceid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Facility getFacilityid() {
		return facility;
	}

	public void setFacilityid(Facility facility) {
		this.facility = facility;
	}

	public TimeSlot getTimeslotid() {
		return timeslot;
	}

	public void setTimeslotid(TimeSlot timeslot) {
		this.timeslot = timeslot;
	}
	
}
