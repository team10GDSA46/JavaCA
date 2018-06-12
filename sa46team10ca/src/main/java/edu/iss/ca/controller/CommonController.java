package edu.iss.ca.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.ca.models.User;
import edu.iss.ca.service.UserService;

@RequestMapping(value = "/home")
@Controller
public class CommonController {

	@Autowired
	private UserService uService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logic(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;

		UserSession us = new UserSession();
		if (user.getName() != null && user.getPassword()!=null) {
			User u = uService.authenticate(user.getName(), user.getPassword());
			
			if(u != null) {
			us.setUser(u);
			// PUT CODE FOR SETTING SESSION ID
			us.setSessionId(session.getId());
			mav = new ModelAndView("redirect:/facility/list");
		} }
		else {
			return mav;
		}
//	session.setAttribute("USERSESSION", us);
	return mav;
		// }
		//
		// }

	}
}
