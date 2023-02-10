package org.cabbookingweb.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Required;

import lombok.NonNull;


@MappedSuperclass
public class AbstractUser {
	@NonNull
	private String userName;
	
	private String password;
	private String mobileNumber;
	private String email;
	public AbstractUser() {
		super();
	}
	public AbstractUser(String userName, String password, String mobileNumber, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	public AbstractUser(String userName, String password) {
		this.userName=userName;
		this.password=password;
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "AbstractUser [userName=" + userName + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + "]";
	}
	
	

}
