package edu.iss.ca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.ca.models.Facility;
import edu.iss.ca.service.FacilityService;

@RequestMapping(value="/facility")
@Controller
public class FacilityController {
	@Autowired
	private FacilityService fService;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView facilityListPage()
	{
		ModelAndView mav = new ModelAndView("testpage");
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

}
