package edu.iss.ca.models;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
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
 * role
 * 
 */

@Entity
@Table(name = "role")
public class Role {
	
	public Role(String role_description) {
		this.roleDescription = role_description;
	}
	
	public Role() {

	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleid")
    private int roleid;
	
	@Column(name = "role_description")
	private String roleDescription;
	
	@OneToMany(mappedBy="role", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<User> userlist = new ArrayList<User>();

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRole_description(){
		return roleDescription;
	}

	public void setRole_description(String role_description){
		this.roleDescription=role_description;
	}

}
