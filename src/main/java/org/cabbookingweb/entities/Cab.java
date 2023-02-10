package org.cabbookingweb.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Scope("prototype")
@javax.persistence.Entity
public class Cab {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cabId")
	private Integer cabId;
	private String carType;
	private Float perKmRate;
	private boolean available;
	
	@javax.persistence.OneToOne

	@JoinColumn(name="driverId")
	private Driver driver; 
	
	public Cab() {
		// TODO Auto-generated constructor stub
	}
	public Cab(String carType, Float perKmRate,Boolean available,Driver driver) {
		//this.cabId = cabId;
		this.carType = carType;
		this.perKmRate = perKmRate;
		this.available=available;
		this.driver=driver;
	}
	public Integer getCabId() {
		return cabId;
	}
	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public Float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(Float perKmRate) {
		this.perKmRate = perKmRate;
	}
	
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", carType=" + carType + ", perKmRate=" + perKmRate + "]";
	}
	
	

}
