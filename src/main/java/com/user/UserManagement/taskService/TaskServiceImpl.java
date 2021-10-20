package com.user.UserManagement.taskService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.UserManagement.model.User;
import com.user.UserManagement.model.UserTask;
import com.user.UserManagement.repository.TaskRepository;
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Override
	public UserTask createTask(UserTask userTask, User user) {
	  return taskRepository.save(userTaskTransformer(userTask, user));

	}

	@Override
	public void deleteTask(int taskId) {
		taskRepository.deleteById(taskId);

	}

	public UserTask getTaskById(int taskId) {
		return taskRepository.findById(taskId).get();

	}

	public UserTask userTaskTransformer(UserTask userTask, User user) {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		userTask.setCreateTime(ts);
		userTask.setLastUpdatedTime(ts);
		userTask.setCreatedBy(user.getUserName());
		userTask.setUser(user);
		return userTask;
	}

	@Override
	public UserTask updateTask(UserTask task, UserTask oldTask) {
		return taskRepository.save(UpdateTaskTransformer(task, oldTask));

	}

	private UserTask UpdateTaskTransformer(UserTask task, UserTask oldTask) {

		task.setTaskId(oldTask.getTaskId());
		task.setCreateTime(oldTask.getCreateTime());
		task.setLastUpdatedTime(new Timestamp(new Date().getTime()));
		task.setCreatedBy(oldTask.getCreatedBy());
		task.setUser(oldTask.getUser());
		return task;
	}

}
