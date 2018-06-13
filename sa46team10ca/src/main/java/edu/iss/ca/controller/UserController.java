package edu.iss.ca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.ca.models.User;
import edu.iss.ca.service.UserService;
import edu.iss.ca.service.UserServiceImpl;
import edu.iss.ca.validator.UserValidator;

@RequestMapping(value="/user")
@Controller
@Configuration
@ComponentScan("edu.iss.ca.service")
public class UserController {

	@Autowired
	private UserService fUser;
	
	//Inject Validator instance and binder
 	@Autowired
	private UserValidator uValidator;
 	
 	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	}	
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public ModelAndView userListPage() throws Exception
	{
		try
		{
			ModelAndView mav = new ModelAndView("userpage");
			List<User> userList = fUser.findAllUser();
			mav.addObject("userList", userList);
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
	public ModelAndView newUserPage() throws Exception{
		try
		{
			ModelAndView mav = new ModelAndView("user-new", "user", new User());
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

	public ModelAndView createNewUser(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes)throws Exception {

		try
		{
			if (result.hasErrors())
				return new ModelAndView("user-new");

			ModelAndView mav = new ModelAndView();
			String message = "New user was successfully created.";

			fUser.createUser(user);
			mav.setViewName("redirect:/user/list");

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

	
	
	@RequestMapping(value = "/edit/{userid}", method = RequestMethod.GET)
	public ModelAndView editFacilityPage(@PathVariable String userid)throws Exception {
		try
		{
			ModelAndView mav = new ModelAndView("user-edit");
			User user = fUser.findUser(Integer.parseInt(userid));
			mav.addObject("user", user);
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
	
	@RequestMapping(value = "/edit/{userid}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute User user, BindingResult result,
			@PathVariable String userid, final RedirectAttributes redirectAttributes) throws Exception {

		try
		{
			if (result.hasErrors())
				return new ModelAndView("user-edit");

			ModelAndView mav = new ModelAndView("redirect:/user/list");
			String message = "User was successfully updated.";

			fUser.changeUser(user);

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
	
	@RequestMapping(value = "/delete/{userid}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable String userid, final RedirectAttributes redirectAttributes)
			throws Exception
	{
		try
		{
			ModelAndView mav = new ModelAndView("redirect:/user/list");
			User user = fUser.findUser(Integer.parseInt(userid));
			fUser.removeUser(user);
			String message = "The user was successfully deleted.";

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
	
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e)
	{
		System.out.print("Exception");
		return "Exception";
	}

}
