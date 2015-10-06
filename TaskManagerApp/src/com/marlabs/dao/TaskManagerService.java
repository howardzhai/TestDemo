package com.marlabs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.marlabs.domain.Task;
import com.marlabs.utility.DBUtility;

public class TaskManagerService {

	private DBUtility dbUtility;

	public TaskManagerService() {

		dbUtility = new DBUtility();

	}

	public void addTask(Task task) {

		try {


			task.setArchived(0);

			Date dt = new Date();
			SimpleDateFormat sdf =
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);

			task.setStartTime(currentTime);
			task.setEndTime(currentTime);
			
			dbUtility.addTask(task);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void archiveTask(int taskId) {

		try {
			dbUtility.archiveTask(taskId);	

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void updateTask(Task task) throws ParseException {

		try {

			dbUtility.updateTask(task);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void changeTaskStatus(int taskId, String status)
			throws ParseException {

		try {

			dbUtility.changeTaskStatus(taskId, status);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Task> getAllTasks() {

		List<Task> tasks = null;

		try {
			tasks = dbUtility.getAllTasks();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tasks;

	}

	public Task getTaskById(int taskId) {

		Task task = null;

		try {
			task = dbUtility.getTaskById(taskId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return task;

	}

}

