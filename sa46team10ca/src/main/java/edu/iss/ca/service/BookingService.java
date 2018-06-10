package edu.iss.ca.service;

import java.util.ArrayList;

import edu.iss.ca.models.Booking;

public interface BookingService {
	
	ArrayList<Booking> findAllBooking();

	Booking findBooking(Integer id);

	Booking createBooking(Booking booking);

	Booking changeBooking(Booking booking);

	void removeBooking(Booking booking);

}
