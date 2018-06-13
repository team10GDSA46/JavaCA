package edu.iss.ca.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.ca.models.Booking;
import edu.iss.ca.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Resource
	private BookingRepository bookingRepository;
	
	@Override
	@Transactional
	public ArrayList<Booking> findAllBooking() {
		return (ArrayList<Booking>)bookingRepository.findAll();
	}

	@Override
	@Transactional
	public Booking findBooking(Integer id) {
		return bookingRepository.getOne(id);
	}

	@Override
	@Transactional
	public Booking createBooking(Booking booking) {
		return bookingRepository.saveAndFlush(booking);
	}

	@Override
	@Transactional
	public Booking changeBooking(Booking booking) {
		return bookingRepository.saveAndFlush(booking);
	}

	@Override
	@Transactional
	public void removeBooking(Booking booking) {
		bookingRepository.delete(booking);
		
	}

	@Override
	@Transactional
	public ArrayList<Booking> findHistoryByUser(Integer id) {
		return bookingRepository.findHistoryByUser(id);
	}

	@Override
	public void cancelBooking(Integer bookingId) {
		Booking b = bookingRepository.findOne(bookingId);
		b.setStatus("CANCELLED");
		bookingRepository.saveAndFlush(b);
	}

}
