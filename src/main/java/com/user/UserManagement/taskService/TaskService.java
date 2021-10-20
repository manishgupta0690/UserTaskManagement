package com.user.UserManagement.taskService;

import com.user.UserManagement.model.User;
import com.user.UserManagement.model.UserTask;

public interface TaskService {
	
	public UserTask createTask(UserTask userTask, User user);
	
	public void deleteTask(int taskId);
	
	public UserTask getTaskById(int taskId);
	
	public UserTask updateTask(UserTask task, UserTask oldTask);

}
