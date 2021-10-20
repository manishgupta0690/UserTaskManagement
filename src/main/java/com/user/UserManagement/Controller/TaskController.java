package com.user.UserManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.UserManagement.model.User;
import com.user.UserManagement.model.UserTask;
import com.user.UserManagement.taskService.TaskService;
import com.user.UserManagement.userService.MyUserDetailsService;

@Controller	
public class TaskController {

	@Autowired
	MyUserDetailsService userDetailsService;

	@Autowired
	TaskService taskService;

	@RequestMapping(value = "/addtask/{id}", method = RequestMethod.POST)
	public String addTask(@ModelAttribute("UserTask") UserTask task, Model model, @PathVariable int id) {
		UserTask userTask = taskService.createTask(task, userDetailsService.getUserById(id));
		model.addAttribute("userTask", userTask.getUser().getTaskList());
		model.addAttribute("user", userTask.getUser());
		return "index";
	}

	@RequestMapping(value = "/new-task/{id}", method = RequestMethod.GET)
	public String createTask(@PathVariable int id, Model model) {
		User user = userDetailsService.getUserById(id);
		UserTask userTask = new UserTask();
		userTask.setUser(user);
		model.addAttribute("UserTask", userTask);
		return "add-task";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeTask(@PathVariable int id, Model model) {
		int userId = taskService.getTaskById(id).getUser().getId();
		taskService.deleteTask(id);
		User user = userDetailsService.getUserById(userId);
		model.addAttribute("userTask", user.getTaskList());
		model.addAttribute("user", user);
		return "index";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		UserTask task = taskService.getTaskById(id);
		model.addAttribute("task", task);
		return "update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String showUpdateForm(@ModelAttribute UserTask task, @PathVariable("id") int id, Model model) {
		UserTask oldTask = taskService.getTaskById(id);
		UserTask userTask = taskService.updateTask(task, oldTask);
		model.addAttribute("userTask", userTask.getUser().getTaskList());
		model.addAttribute("user", userTask.getUser());
		return "index";
	}

	@RequestMapping(value = "/display-task/{id}", method = RequestMethod.GET)
	public String getTaskList(@PathVariable("id") int id, Model model) {
		User user = userDetailsService.getUserById(id);
		model.addAttribute("userTask", user.getTaskList());
		model.addAttribute("user", user);
		return "index";
	}
}
