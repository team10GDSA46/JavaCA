package edu.iss.ca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.iss.ca.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
