package com.user.UserManagement.taskService;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.UserManagement.model.User;
import com.user.UserManagement.model.UserTask;
import com.user.UserManagement.repository.TaskRepository;

@SpringBootTest
public class TaskServiceImplTest {

	@InjectMocks
	TaskServiceImpl taskService;

	@Mock
	TaskRepository taskRepository;

	@Test
	public void getTaskByIdTest() {

		Mockito.when(taskRepository.findById(Mockito.anyInt())).thenReturn(optionalTask());
		UserTask task = taskService.getTaskById(1);
		System.out.println(task);
		assertEquals("Test", task.getCreatedBy());

	}

	@Test
	public void createTaskTest() {
		Mockito.when(taskRepository.save(Mockito.any(UserTask.class))).thenReturn(getTask());
		UserTask userTask = taskService.createTask(getTask(), getUser());
		assertEquals(1, userTask.getTaskId());
	}

	@Test
	public void updateTask() {
		UserTask oldTask = getTask();
		oldTask.setTaskName("oldUser");
		Mockito.when(taskRepository.save(Mockito.any(UserTask.class))).thenReturn(oldTask);
		UserTask userTask = taskService.updateTask(getTask(), oldTask);
		assertEquals(oldTask.getTaskName(), userTask.getTaskName());
	}


	public UserTask getTask() {
		UserTask task = new UserTask();
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		task.setCreatedBy("Test");
		task.setTaskId(1);
		task.setCreateTime(ts);
		task.setLastUpdatedTime(ts);
		return task;
	}

	public User getUser() {
		User user = new User();
		user.setId(1);
		user.setUserName("Test");
		return user;
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

	public Optional<UserTask> optionalTask() {
		User user = new User();
		user.setId(1);
		user.setUserName("Test");
		Optional<UserTask> userTask = Optional.of(getTask());
		return userTask;
	}

}
