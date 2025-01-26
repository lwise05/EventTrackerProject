package com.skilldistillery.comedyevent.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	private String street;
	
	private String street2;
	
	private String city;
	
	private String state;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	private String country;
	
	@JsonIgnore
	@OneToMany(mappedBy ="venue")
	private List<ComedyEvent> events;

	public Venue() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	public List<ComedyEvent> getEvents() {
		return events;
	}

	public void setEvents(List<ComedyEvent> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", street=" + street + ", street2="
				+ street2 + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", country="
				+ country + "]";
	}
	
	
	
	
}
