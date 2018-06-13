package edu.iss.ca.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.ca.models.Booking;
import edu.iss.ca.models.Facility;
import edu.iss.ca.models.Maintenance;
import edu.iss.ca.models.TimeSlot;
import edu.iss.ca.service.BookingService;
import edu.iss.ca.service.FacilityService;
import edu.iss.ca.service.TimeSlotService;
import edu.iss.ca.service.MaintenanceService;

@RequestMapping(value="/facility")
@Controller
public class MaintenanceController {
	@Autowired
	private FacilityService fService;
	
	@Autowired
	private BookingService bService;
	
	@Autowired
	private TimeSlotService tsService;
	
	@Autowired
	private MaintenanceService mService;
	
	@InitBinder("maintenance")
	private void initCourseBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
	}
	
	//booking get
	@RequestMapping(value="/maintenance",method=RequestMethod.GET)
	public ModelAndView facilityBooking()
	{
		ModelAndView mav = new ModelAndView("maintenance-process", "maintenance", new Maintenance());
		ArrayList<Facility> fList = fService.findAllFacility();
		ArrayList<TimeSlot> tsList = tsService.findAllTimeSlot();
		mav.addObject("flist", fList);
		mav.addObject("tslist", tsList);
		return mav;
	}
	
	//bookingslot post
	@RequestMapping(value = "/maintenanceslot", method = RequestMethod.POST)
	public ModelAndView testing1(@ModelAttribute Maintenance maintenance, BindingResult result,
			final RedirectAttributes redirectAttributes,
			@RequestParam("facId") int fid) {
		
		ModelAndView mav = new ModelAndView("maintenanceslot");
		ArrayList<TimeSlot> tsList = tsService.findAllTimeSlot();
		Facility f = fService.findFacility(fid);
		maintenance.setFacilityid(f);
		mav.addObject("maintenance", maintenance);
		mav.addObject("tslist", tsList);
		return mav;
	}
	
	
	///booking/process post
	@RequestMapping(value = "/maintenance/process", method = RequestMethod.POST)
	public ModelAndView testing(@ModelAttribute Maintenance maintenance, BindingResult result,
			final RedirectAttributes redirectAttributes,
			@RequestParam("ts") int[] tsIds) {
		ArrayList<TimeSlot> ts = new ArrayList<TimeSlot>();
		for(int id : tsIds) {
			TimeSlot t = tsService.findTimeSlot(id);
			ts.add(t);
		}
		
		for(TimeSlot x : ts) {
			Maintenance multi = 
					new Maintenance(maintenance.getDate(), maintenance.getFacility(), 
					maintenance.getTimeslot());
			multi.setDate(maintenance.getDate());
			multi.setTimeslot(x);
			mService.createMaintenance(multi);
		}
		ModelAndView mav = new ModelAndView("booking-history");
		return mav;
	}
	
}
