package com.user.UserManagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "roles")
	private String roles;
	
	@OneToMany(mappedBy="user")
	List<UserTask> taskList;
	
	public User() {}
	
	public User(String userName, String password, String roles) {
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public List<UserTask> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<UserTask> taskList) {
		this.taskList = taskList;
	}
	
	

}
