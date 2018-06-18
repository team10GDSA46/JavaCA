package edu.iss.ca.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.ca.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	@Query("SELECT b from Booking b where b.user.userid =:uid ")
	ArrayList<Booking> findHistoryByUser(@Param("uid") Integer uid);
	
	@Query("SELECT distinct b.timeslot.id from Booking b where b.user.userid =:uid and b.date =:date and b.facility.facilityid =:fid")
	ArrayList<Integer> findBookedSlots(@Param("uid") Integer uid, @Param("date") Date date, @Param("fid") Integer fid);
}
