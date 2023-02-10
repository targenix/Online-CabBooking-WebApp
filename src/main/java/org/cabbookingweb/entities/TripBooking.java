package org.cabbookingweb.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@javax.persistence.Entity
public class TripBooking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tripBookingId")
	private Integer tripBookingId;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private Boolean status;
	private Float distanceInKm;
	private Float bill;
	private LocalDate date;

	@javax.persistence.OneToOne
	@JoinColumn(name="customerId")
	//@OnDelete(action=OnDeleteAction.CASCADE)
	private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="driverId")//, referencedColumnName = "driverId")
	//@OnDelete(action=OnDeleteAction.CASCADE)
	private Driver driver;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cabId")//, referencedColumnName = "driverId")
	//@OnDelete(action=OnDeleteAction.CASCADE)
	private Cab cab;
	
	

	public TripBooking() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public TripBooking(String fromLocation, String toLocation, LocalDateTime fromDateTime,
			LocalDateTime toDateTime, Boolean status, Float distanceInKm, Float bill, Customer customer,
			Driver driver,Cab cab,LocalDate date) {
		//super();
		//this.tripBookingId = tripBookingId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
		this.customer = customer;
		this.driver = driver;
		this.cab=cab;
		this.date=date;
	}

	public Integer getTripBookingId() {
		return tripBookingId;
	}

	public void setTripBookingId(Integer tripBookingId) {
		this.tripBookingId = tripBookingId;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public LocalDateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Float getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(Float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public Float getBill() {
		return bill;
	}

	public void setBill(Float bill) {
		this.bill = bill;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}
	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TripBooking [tripBookingId=" + tripBookingId + ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", fromDateTime=" + fromDateTime + ", toDateTime=" + toDateTime + ", status=" + status
				+ ", distanceInKm=" + distanceInKm + ", bill=" + bill + ", DateOfBooking=" + date + ", customer=" + customer
				+ ", driver=" + driver + ", cab=" + cab + "]";
	}

}
