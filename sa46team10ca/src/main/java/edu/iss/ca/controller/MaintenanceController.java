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

import edu.iss.ca.models.Facility;
import edu.iss.ca.models.Maintenance;
import edu.iss.ca.models.TimeSlot;
import edu.iss.ca.service.FacilityService;
import edu.iss.ca.service.TimeSlotService;
import edu.iss.ca.service.MaintenanceService;

@RequestMapping(value="/maintenance")
@Controller
public class MaintenanceController {
	@Autowired
	private FacilityService fService;
	
	@Autowired
	private TimeSlotService tsService;
	
	@Autowired
	private MaintenanceService mService;
	
	@InitBinder("maintenance")
	private void initCourseBinder(WebDataBinder binder)throws Exception {
		try
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateFormat.setLenient(false);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		}
		catch(Exception e)
		{
			String exceptionOccurred = "Exception";
			if(exceptionOccurred.equalsIgnoreCase("Exception"))
				throw new Exception("Exception");
		}
		
		
	}
	
	//booking get
	@RequestMapping(value="/maintenance",method=RequestMethod.GET)
	public ModelAndView facilityBooking()throws Exception
	{
		try
		{
			ModelAndView mav = new ModelAndView("maintenance-process", "maintenance", new Maintenance());
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
	
	//bookingslot post
	@RequestMapping(value = "/maintenanceslot", method = RequestMethod.POST)
	public ModelAndView testing1(@ModelAttribute Maintenance maintenance, BindingResult result,
			final RedirectAttributes redirectAttributes,
			@RequestParam("facId") int fid)throws Exception {
		
		try
		{
			ModelAndView mav = new ModelAndView("maintenanceslot");
			ArrayList<TimeSlot> tsList = tsService.findAllTimeSlot();
			Facility f = fService.findFacility(fid);
			maintenance.setFacilityid(f);
			mav.addObject("maintenance", maintenance);
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
	
	
	///booking/process post
	@RequestMapping(value = "/maintenance/process", method = RequestMethod.POST)
	public ModelAndView testing(@ModelAttribute Maintenance maintenance, BindingResult result,
			final RedirectAttributes redirectAttributes,
			@RequestParam("ts") int[] tsIds) throws Exception{
		try
		{
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
			ModelAndView mav = new ModelAndView("redirect:/maintenance/list");
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
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView facilityListPage() throws Exception
	{
		try
		{
			ModelAndView mav = new ModelAndView("maintenance-list");
			List<Maintenance> mList = mService.findAllMaintenance();
			mav.addObject("mList", mList);
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
	
	@RequestMapping(value = "/delete/{maintenanceid}", method = RequestMethod.GET)
	public ModelAndView deleteMaintenance(@PathVariable String maintenanceid, final RedirectAttributes redirectAttributes)
			throws Exception
	{

			ModelAndView mav = new ModelAndView("redirect:/maintenance/list");
			Maintenance maintenance = mService.findMaintenance(Integer.parseInt(maintenanceid));
			mService.removeMaintenance(maintenance);
			String message = "The maintenance was successfully deleted.";

			redirectAttributes.addFlashAttribute("message", message);
			return mav;

	}
}