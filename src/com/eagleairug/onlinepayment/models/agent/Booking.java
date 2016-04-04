package com.eagleairug.onlinepayment.models.agent;

import java.util.List;

public class Booking {
	private int id;
	private String clientName;
	private int agent_id;
	private String bookingRef;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}
	public String getBookingRef() {
		return bookingRef;
	}
	public void setBookingRef(String bookingRef) {
		this.bookingRef = bookingRef;
	}
	
	public boolean registerBooking(Booking booking){
		return false;
	}
	
	public boolean editBooking(Booking booking){
	
		return false;
	}
	
	
	public List<Booking> getAllBooking(){
		return null;
	}
	
	public Booking getBooking(int bookingId){
		return null;
	}
	
	
	
	
	
}
