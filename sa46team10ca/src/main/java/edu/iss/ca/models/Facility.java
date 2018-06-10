package edu.iss.ca.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facility")
public class Facility {
	@Id
	private int facilityid;
	
	@Column(name="name")
	private String name;
	
	public Facility() {}
	
	public Facility(int facilityid, String name) {
		super();
		this.facilityid = facilityid;
		this.name = name;
	}
	public int getFacilityid() {
		return facilityid;
	}
	public void setFacilityid(int facilityid) {
		this.facilityid = facilityid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Facility [facilityid=" + facilityid + ", name=" + name + "]";
	}

}