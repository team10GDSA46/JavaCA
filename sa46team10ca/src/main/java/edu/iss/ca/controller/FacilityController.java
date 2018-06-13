package edu.iss.ca.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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

@RequestMapping(value="/facility")
@Controller
public class FacilityController {
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
	public ModelAndView facilityListPage()
	{
		ModelAndView mav = new ModelAndView("facility-list");
		List<Facility> facilityList = fService.findAllFacility();
		mav.addObject("facilityList", facilityList);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newFacilityPage() {
		ModelAndView mav = new ModelAndView("facility-new", "facility", new Facility());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewFacility(@ModelAttribute Facility facility, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("facility-new");

		ModelAndView mav = new ModelAndView();
		String message = "New facility was successfully created.";

		fService.createFacility(facility);
		mav.setViewName("redirect:/facility/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editFacilityPage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("facility-edit");
		Facility facility = fService.findFacility(Integer.parseInt(id));
		mav.addObject("facility", facility);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editFacility(@ModelAttribute Facility facility, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes) /*throws EmployeeNotFound*/ {

		if (result.hasErrors())
			return new ModelAndView("facility-edit");

		ModelAndView mav = new ModelAndView("redirect:/facility/list");
		String message = "Facility was successfully updated.";

		fService.changeFacility(facility);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteFacility(@PathVariable String id, final RedirectAttributes redirectAttributes)
			//throws EmployeeNotFound 
	{
		ModelAndView mav = new ModelAndView("redirect:/facility/list");
		Facility facility = fService.findFacility(Integer.parseInt(id));
		fService.removeFacility(facility);
		String message = "The facility " + facility.getFacilityid() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value="/booking",method=RequestMethod.GET)
	public ModelAndView facilityBooking()
	{
		ModelAndView mav = new ModelAndView("booking-process", "booking", new Booking());
		ArrayList<Facility> fList = fService.findAllFacility();
		ArrayList<TimeSlot> tsList = tsService.findAllTimeSlot();
		mav.addObject("flist", fList);
		mav.addObject("tslist", tsList);
		return mav;
	}
	
//	@RequestMapping(value = "/booking/process", method = RequestMethod.POST)
//	public ModelAndView processBooking(@ModelAttribute Booking booking, BindingResult result,
//			final RedirectAttributes redirectAttributes) {
//
//		ModelAndView mav = new ModelAndView();
//		String message = "New facility was successfully created.";
//		
//		bService.createBooking(booking);
//		mav.setViewName("redirect:/facility/list");
//
//		redirectAttributes.addFlashAttribute("message", message);
//		return mav;
//	}
	
	@RequestMapping(value = "/booking/testing", method = RequestMethod.POST)
	public ModelAndView testing(@ModelAttribute Booking booking, BindingResult result,
			final RedirectAttributes redirectAttributes,
			@RequestParam("ts") int[] tsIds) {
		ArrayList<TimeSlot> ts = new ArrayList<TimeSlot>();
		for(int id : tsIds) {
			TimeSlot t = tsService.findTimeSlot(id);
			ts.add(t);
		}
		
		for(TimeSlot x : ts) {
			Booking multi = 
					new Booking(null, booking.getFacility(), 
					booking.getTimeslot(), booking.getStatus());
			multi.setDate(booking.getDate());
			multi.setTimeslot(x);
			bService.createBooking(multi);
		}
		ModelAndView mav = new ModelAndView("booking-history");
		return mav;
	}
	
	@RequestMapping(value="/bookingslot",method=RequestMethod.GET)
	public ModelAndView facilityBookingSlot()
	{
		ModelAndView mav = new ModelAndView("testpage");
		ArrayList<TimeSlot> tsList = tsService.findAllTimeSlot();
		mav.addObject("booking", new Booking());
		mav.addObject("tslist", tsList);
		return mav;
	}
	
	@RequestMapping(value = "/bookingslot", method = RequestMethod.POST)
	public ModelAndView testing1(@ModelAttribute Booking booking, BindingResult result,
			final RedirectAttributes redirectAttributes,
			@RequestParam("facId") int fid) {
		
		ModelAndView mav = new ModelAndView("bookingslot");
		ArrayList<TimeSlot> tsList = tsService.findAllTimeSlot();
		Facility f = fService.findFacility(fid);
		booking.setFacility(f);
		mav.addObject("booking", booking);
		mav.addObject("tslist", tsList);
		return mav;
		
		
//		ModelAndView mav = new ModelAndView("testpage2");
//		mav.addObject("nums", nums);
//		mav.addObject("booking", booking);
//		return mav;
	}

}
