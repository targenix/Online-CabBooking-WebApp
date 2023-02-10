package org.cabbookingweb.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@javax.persistence.Entity
public class Admin extends AbstractUser {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adminId;

	public Admin() {
		//super();
		// TODO Auto-generated constructor stub
	}


	public Admin(String userName, String password, String mobileNumber, String email) {
		super(userName, password, mobileNumber, email);
		//this.adminId = adminId;
		
		// TODO Auto-generated constructor stub
	}


	public Integer getAdminId() {
		return adminId;
	}
//
//
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "] | "+super.toString();
	}
	
	
	

}
