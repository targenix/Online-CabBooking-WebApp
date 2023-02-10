package org.cabbookingweb.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Scope("prototype")
@javax.persistence.Entity
public class Driver extends AbstractUser {

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="driverId")
	private Integer driverId;
	private String licenceNo;
	private Float rating;
	private boolean available;

	@javax.persistence.OneToOne

	@JoinColumn(name="cabId")
	private Cab cab; 
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "driver",orphanRemoval = true)
//	@JsonIgnore
//	private List<TripBooking> tripBooking;

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver( String licenceNo, Float rating, Cab cab, String userName, String password,
			String mobileNumber, String email,Boolean available) {
		super(userName, password, mobileNumber, email);
		//this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.rating = rating;
		this.cab = cab;
		this.available=available;
		// TODO Auto-generated constructor stub
	}

	public Driver(String userName, String password) {
		super(userName,password);
		// TODO Auto-generated constructor stub
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}
	

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", rating=" + rating + ", cab=" + cab.getCabId()
				+ "]";
	}
	

}
