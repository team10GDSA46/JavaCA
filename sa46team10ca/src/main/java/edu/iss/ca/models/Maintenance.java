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
@Table(name="maintenance")
public class Maintenance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maintenanceid")
	private int maintenanceid;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern= "dd/MM/yyyy" )
	@Column(name = "date")
	private Date date;
	
	public TimeSlot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(TimeSlot timeslot) {
		this.timeslot = timeslot;
	}

	@ManyToOne
	@JoinColumn(name = "facilityid")
	private Facility facility;
	
	@ManyToOne
	@JoinColumn(name = "timeslotid")
	private TimeSlot timeslot;
	
	public Maintenance() {
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Maintenance(Date date, Facility facility, TimeSlot timeslot) {
		super();
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
