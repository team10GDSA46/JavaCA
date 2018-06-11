package edu.iss.ca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.ca.models.Facility;
import edu.iss.ca.service.FacilityService;

@RequestMapping(value="/facility")
@Controller
@Configuration
@ComponentScan("edu.iss.ca.service")
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

}
