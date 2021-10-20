package com.user.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.UserManagement.model.UserTask;

public interface TaskRepository extends JpaRepository<UserTask, Integer> {
}
