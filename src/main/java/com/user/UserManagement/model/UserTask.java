package com.user.UserManagement.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class UserTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;
	
	@Column(name ="task_name")
	private String taskName;
	
	@Column(name ="description")
	private String description;
	
	@Column(name="create_time")
	private Timestamp createTime;
	
	@Column(name="last_update")
	private Timestamp lastUpdatedTime;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
	private User user;
	
	public UserTask() {}
	public UserTask(String taskName, String description, Timestamp createTime, Timestamp lastUpdatedTime,
			String createdBy) {
		super();
		this.taskName = taskName;
		this.description = description;
		this.createTime = createTime;
		this.lastUpdatedTime = lastUpdatedTime;
		this.createdBy = createdBy;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Timestamp lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	
	
	

}
