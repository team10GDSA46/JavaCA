package edu.iss.ca.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * role
 * 
 */

@Entity
@Table(name = "role")
public class Role {
	
	public Role(String role_description) {
		this.role_description = role_description;
	}
	
	public Role() {

	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "role_description")
	private String role_description;

	public String getRole_description(){
		return role_description;
	}

	public void setRole_description(String role_description){
		this.role_description=role_description;
	}

}
