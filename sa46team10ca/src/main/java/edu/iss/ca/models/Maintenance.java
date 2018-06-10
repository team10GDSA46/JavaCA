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
public class Maintenance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingid")
	private int maintenanceid;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "facilityid")
	private Facility facilityid;
	
	@Column(name = "timeslotid")
	private int timeslotid;
	
	public Maintenance() {
	}

	public Maintenance(int maintenanceid, Date date, Facility facilityid, int timeslotid) {
		super();
		this.maintenanceid = maintenanceid;
		this.date = date;
		this.facilityid = facilityid;
		this.timeslotid = timeslotid;
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
		return facilityid;
	}

	public void setFacilityid(Facility facilityid) {
		this.facilityid = facilityid;
	}

	public int getTimeslotid() {
		return timeslotid;
	}

	public void setTimeslotid(int timeslotid) {
		this.timeslotid = timeslotid;
	}
	
}
