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
import edu.iss.ca.service.BookingService;
import edu.iss.ca.service.FacilityService;
import edu.iss.ca.service.MaintenanceService;
import edu.iss.ca.service.TimeSlotService;
import edu.iss.ca.controller.CommonController;

@RequestMapping(value="/facility")
@Controller
public class FacilityController {
	@Autowired
	private FacilityService fService;
	
	@Autowired
	private BookingService bService;
	
	@Autowired
	private TimeSlotService tsService;
	
	@Autowired
	private MaintenanceService mService;
	
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
			ModelAndView mav = new ModelAndView("facility-list");
			List<Facility> facilityList = fService.findAllFacility();
			mav.addObject("facilityList", facilityList);
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
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newFacilityPage() throws Exception{
		try
		{
			ModelAndView mav = new ModelAndView("facility-new", "facility", new Facility());
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

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewFacility(@ModelAttribute Facility facility, BindingResult result,
			final RedirectAttributes redirectAttributes) throws Exception {

		try
		{
			if (result.hasErrors())
				return new ModelAndView("facility-new");

			ModelAndView mav = new ModelAndView();
			String message = "New facility was successfully created.";

			fService.createFacility(facility);
			mav.setViewName("redirect:/facility/list");

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
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editFacilityPage(@PathVariable String id) throws Exception{
		try
		{
			ModelAndView mav = new ModelAndView("facility-edit");
			Facility facility = fService.findFacility(Integer.parseInt(id));
			mav.addObject("facility", facility);
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
	public ModelAndView editFacility(@ModelAttribute Facility facility, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes) throws Exception {

		try
		{
			if (result.hasErrors())
				return new ModelAndView("facility-edit");

			ModelAndView mav = new ModelAndView("redirect:/facility/list");
			String message = "Facility was successfully updated.";

			fService.changeFacility(facility);

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
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteFacility(@PathVariable String id, final RedirectAttributes redirectAttributes)
			throws Exception
	{
		try
		{
			ModelAndView mav = new ModelAndView("redirect:/facility/list");
			Facility facility = fService.findFacility(Integer.parseInt(id));
			fService.removeFacility(facility);
			String message = "The facility " + facility.getFacilityid() + " was successfully deleted.";

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
	
	@RequestMapping(value="/booking",method=RequestMethod.GET)
	public ModelAndView facilityBooking() throws Exception
	{
		try
		{
			ModelAndView mav = new ModelAndView("booking-process", "booking", new Booking());
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
	
	@RequestMapping(value = "/booking/process", method = RequestMethod.POST)
	public ModelAndView testing(@ModelAttribute Booking booking, BindingResult result,
			final RedirectAttributes redirectAttributes,
			@RequestParam("ts") int[] tsIds, HttpSession session) throws Exception {
		try
		{
			ArrayList<TimeSlot> ts = new ArrayList<TimeSlot>();
			UserSession us = (UserSession) session.getAttribute("USERSESSION");
			for(int id : tsIds) {
				TimeSlot t = tsService.findTimeSlot(id);
				ts.add(t);
			}
			
			for(TimeSlot x : ts) {
				Booking multi = 
						new Booking(us.getUser(), booking.getFacility(), 
						booking.getTimeslot(), booking.getStatus());
				multi.setDate(booking.getDate());
				multi.setTimeslot(x);
				bService.createBooking(multi);
			}
			ModelAndView mav = new ModelAndView("redirect:/facility/booking/history");
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
	
	@RequestMapping(value = "/bookingslot", method = RequestMethod.POST)
	public ModelAndView testing1(@ModelAttribute Booking booking, BindingResult result,
			final RedirectAttributes redirectAttributes,
			HttpSession session,
			@RequestParam("facId") int fid) throws Exception {
		
		try
		{
			ModelAndView mav = new ModelAndView("bookingslot");
			UserSession us = (UserSession) session.getAttribute("USERSESSION");
			ArrayList<TimeSlot> tsList = tsService.findAllTimeSlot();
			Facility f = fService.findFacility(fid);
			booking.setFacility(f);
			ArrayList<Integer> bSlots = bService.findBookedSlots(us.getUser().getUserid(), 
					booking.getDate(), f.getFacilityid());
			ArrayList<Integer> mSlots = mService.findSlotsUnderMaintenance(booking.getDate(), f.getFacilityid());
			mSlots.add(1);
			mav.addObject("booking", booking);
			mav.addObject("tslist", tsList);
			mav.addObject("bslots", bSlots);
			mav.addObject("mslots", mSlots);
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
	
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e)
	{
		System.out.print("Exception");
		return "Exception";
	}
	
	@RequestMapping(value="/booking/history",method=RequestMethod.GET)
	public ModelAndView bookingHistory(HttpSession session)
	{
		//int userid = 1;
		ModelAndView mav = new ModelAndView("booking-history");
		//add the session code here
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		
		ArrayList<Booking> history = bService.findHistoryByUser(us.getUser().getUserid());
		mav.addObject("history", history);
		return mav;
	}
	
	
	@RequestMapping(value="/booking/cancel/{id}",method=RequestMethod.GET)
	public ModelAndView cancelBooking(@PathVariable String id)
	{
		ModelAndView mav = new ModelAndView("redirect:/facility/booking/history");
		bService.cancelBooking(Integer.parseInt(id));
		return mav;
	}
}
