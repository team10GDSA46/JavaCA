package edu.iss.ca.controller;

import java.util.ArrayList;
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

import edu.iss.ca.models.User;
import edu.iss.ca.service.UserService;
import edu.iss.ca.service.UserServiceImpl;

@RequestMapping(value="/user")
@Controller
@Configuration
@ComponentScan("edu.iss.ca.service")
public class UserController {

	@Autowired
	private UserService fUser;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView userListPage()
	{
		ModelAndView mav = new ModelAndView("userpage");
		List<User> userList = fUser.findAllUser();
		mav.addObject("userList", userList);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newUserPage() {
		ModelAndView mav = new ModelAndView("user-new", "user", new User());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute User user, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("employee-new");

		ModelAndView mav = new ModelAndView();
		String message = "New user was successfully created.";

		fUser.createUser(user);
		mav.setViewName("redirect:/user/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{userid}", method = RequestMethod.GET)
	public ModelAndView editFacilityPage(@PathVariable String userid) {
		ModelAndView mav = new ModelAndView("user-edit");
		User user = fUser.findUser(Integer.parseInt(userid));
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{userid}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute User user, BindingResult result,
			@PathVariable String userid, final RedirectAttributes redirectAttributes) /*throws EmployeeNotFound*/ {

		if (result.hasErrors())
			return new ModelAndView("user-edit");

		ModelAndView mav = new ModelAndView("redirect:/user/list");
		String message = "User was successfully updated.";

		fUser.changeUser(user);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/delete/{userid}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable String userid, final RedirectAttributes redirectAttributes)
			//throws EmployeeNotFound 
	{
		ModelAndView mav = new ModelAndView("redirect:/user/list");
		User user = fUser.findUser(Integer.parseInt(userid));
		fUser.removeUser(user);
		String message = "The user was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}