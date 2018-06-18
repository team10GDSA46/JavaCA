package edu.iss.ca.service;

import java.util.ArrayList;
import java.util.Date;

import edu.iss.ca.models.Booking;

public interface BookingService {
	
	ArrayList<Booking> findAllBooking();

	Booking findBooking(Integer id);

	Booking createBooking(Booking booking);

	Booking changeBooking(Booking booking);

	void removeBooking(Booking booking);

	ArrayList<Booking> findHistoryByUser(Integer id);
	
	void cancelBooking(Integer bookingId);
	
	ArrayList<Integer> findBookedSlots(Integer userId, Date date, Integer facId);
}
