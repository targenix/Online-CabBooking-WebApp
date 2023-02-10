package org.cabbookingweb.entities;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressid;
	private String fromCity;
	private String toCity;
	
	private float distance;
	
	private long minutes;
	
//	@OneToMany
//	@JoinColumn(name="tripBookingId")
//	private List<TripBooking> tripbooking;
	
	public Address()
	{
		super();
	}

	public Address(String fromcity, String tocity,float distance,long minutes) {
		super();
		fromCity = fromcity;
		toCity = tocity;
		//this.tripbooking = tripbooking;
		this.distance=distance;
		this.minutes=minutes;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getFromcity() {
		return fromCity;
	}

	public void setFromcity(String fromcity) {
		fromCity = fromcity;
	}

	public String getTocity() {
		return toCity;
	}

	public void setTocity(String tocity) {
		toCity = tocity;
	}
	

//	public List<TripBooking> getTripbooking() {
//		return tripbooking;
//	}
//
//	public void setTripbooking(List<TripBooking> tripbooking) {
//		this.tripbooking = tripbooking;
//	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	

	public long getTime() {
		return minutes;
	}

	public void setTime(long minutes) {
		this.minutes = minutes;
	}

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", Fromcity=" + fromCity + ", Tocity=" + toCity + ", distance="
				+ distance +  "]";
	}
	
	
	

}
