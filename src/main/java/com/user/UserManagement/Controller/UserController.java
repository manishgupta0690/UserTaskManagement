package com.user.UserManagement.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.UserManagement.model.User;
import com.user.UserManagement.model.UserTask;
import com.user.UserManagement.userService.MyUserDetailsService;

@Controller
public class UserController {

	@Autowired
	MyUserDetailsService userDetailsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Authentication authentication, Model model) {
		User user = userDetailsService.getUserByUserName(authentication.getName());
		UserTask userTask = new UserTask();
		userTask.setUser(user);
		model.addAttribute("UserTask", userTask);
		return "add-task"; // view
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
}
