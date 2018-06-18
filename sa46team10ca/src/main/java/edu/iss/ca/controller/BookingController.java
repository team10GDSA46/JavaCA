package edu.iss.ca.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
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
import edu.iss.ca.service.BookingService;
import edu.iss.ca.service.FacilityService;
import edu.iss.ca.service.TimeSlotService;

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
			ModelAndView mav = new ModelAndView("booking-edit","booking", new Booking());
			Booking booking = bService.findBooking(Integer.parseInt(id));
			mav.addObject("booking", booking);
			ArrayList<Facility> fList = fService.findAllFacility();
			ArrayList<TimeSlot> tsList = tsService.findAllTimeSlot();
			mav.addObject("flist", fList);
			mav.addObject("tslist", tsList);
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
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute Booking booking, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes,
			@RequestParam("facId") String fid) throws Exception {
		try
		{
			if (result.hasErrors())
				return new ModelAndView("booking-edit");
			String url;
				url="redirect:/booking/list";
			
			Facility f = fService.findFacility(Integer.parseInt(fid));
			
			ModelAndView mav = new ModelAndView(url);
			booking.setFacility(f);
			String message = "Booking was successfully updated.";
			bService.changeBooking(booking);
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