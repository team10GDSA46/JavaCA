package edu.iss.ca.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.ca.models.User;
import edu.iss.ca.service.UserService;

@RequestMapping(value = "/")
@Controller
public class CommonController {

	@Autowired
	private UserService uService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView logic(@ModelAttribute User user, HttpSession session, BindingResult result) throws Exception {
		try
		{
			session.setAttribute("Login",0);
			ModelAndView mav = new ModelAndView("login");
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

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result)throws Exception {
		try
		{
			ModelAndView mav = new ModelAndView("login");
			if (result.hasErrors())
				return mav;

			UserSession us = new UserSession();
			if (user.getName() != null && user.getPassword() != null) {
				User u = uService.authenticate(user.getName(), user.getPassword());
				if (u != null) {

					us.setUser(u);
					us.setSessionId(session.getId());
					session.setAttribute("Login",1);
					session.setAttribute("USER", u);
					session.setAttribute("Role",u.getRole());

					if (u.getRole().equalsIgnoreCase("admin")){
						mav = new ModelAndView("redirect:/facility/list");
					} else {
						mav = new ModelAndView("redirect:/user/list");
					}
				}
			}
			
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
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session)throws Exception {
		try
		{
			session.invalidate();
			return "redirect:/home/login";
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
}
