package com.skilldistillery.comedyevent.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comedy_event")
public class ComedyEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "performance_date")
	private LocalDate performanceDate;
	
	private int rating;
	
	@Column(name = "ticket_price")
	private double ticketPrice;
	
	private String notes;
	
	@ManyToOne
	@JoinColumn(name = "comedian_id")
	private Comedian comedian;
	
	
	@ManyToOne
	@JoinColumn(name = "venue_id")
	private Venue venue;
	

	public ComedyEvent() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	
	public LocalDate getPerformanceDate() {
		return performanceDate;
	}

	public void setPerformanceDate(LocalDate performanceDate) {
		this.performanceDate = performanceDate;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	

	public Comedian getComedian() {
		return comedian;
	}

	public void setComedian(Comedian comedian) {
		this.comedian = comedian;
	}

	
	
	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "ComedyEvent [id=" + id + ", rating=" + rating + "]";
	}
	
	
	
}
