 	package edu.iss.ca.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.ca.models.Booking;
import edu.iss.ca.models.Facility;
import edu.iss.ca.models.TimeSlot;
import edu.iss.ca.models.User;
import edu.iss.ca.service.BookingService;
import edu.iss.ca.service.FacilityService;
import edu.iss.ca.service.TimeSlotService;
import edu.iss.ca.controller.CommonController;

@RequestMapping(value="/booking")
@Controller
public class BookingController {
	@Autowired
	private FacilityService fService;
	
	@Autowired
	private BookingService bService;
	
	@Autowired
	private TimeSlotService tsService;
	
	@InitBinder("booking")
	private void initCourseBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
	}
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView facilityListPage() throws Exception
	{
		try
		{
			ModelAndView mav = new ModelAndView("bookingAll");
			List<Booking> bookingList = bService.findAllBooking();
			mav.addObject("bookingList", bookingList);
			return mav;
		}
		catch(Exception e)
		{
			String exceptionOccurred = "Exception";
			if(exceptionOccurred.equalsIgnoreCase("Exception"))
				throw new Exception("Exception");
		}
		return null;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editBookingPage(@PathVariable String id) throws Exception{
		try
		{
			ModelAndView mav = new ModelAndView("booking-edit");
			Booking booking = bService.findBooking(Integer.parseInt(id));
			mav.addObject("booking", booking);
			return mav;
		}
		catch(Exception e)
		{
			String exceptionOccurred = "Exception";
			if(exceptionOccurred.equalsIgnoreCase("Exception"))
				throw new Exception("Exception");
		}
		return null;
	}
	
	@RequestMapping(value = "/delete/{bookingid}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable String bookingid, final RedirectAttributes redirectAttributes)
			throws Exception
	{
		try
		{
			ModelAndView mav = new ModelAndView("redirect:/booking/list");
			Booking booking = bService.findBooking(Integer.parseInt(bookingid));
			bService.removeBooking(booking);
			String message = "The booking was successfully deleted.";

			redirectAttributes.addFlashAttribute("message", message);
			return mav;
		}
		catch(Exception e)
		{
			String exceptionOccurred = "Exception";
			if(exceptionOccurred.equalsIgnoreCase("Exception"))
				throw new Exception("Exception");
		}
		return null;
	}
}
