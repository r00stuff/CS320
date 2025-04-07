package main.java.edu.snhu.raulochoa.taskservice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class TaskService {

	private static final String TASK_NOT_FOUND = "Task ID was not found";
	private static final String DUPLICATE_TASK_ID = "Duplicate task ID found";
	
	private final List<Task> tasks = new ArrayList<>();
	
	public void addTask(Task task) {
		for (Task t : tasks) {
			if (t.getTaskId().equals(task.getTaskId())) {
				throw new IllegalArgumentException(DUPLICATE_TASK_ID);
			}
		}
		tasks.add(task);
	}

	public void updateTask(Task updatedtask) {

		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getTaskId().equals(updatedtask.getTaskId())) {
				tasks.set(i, updatedtask);
				return;
			}
		}

		throw new NoSuchElementException(TASK_NOT_FOUND);

	}

	public void deleteTask(String taskId) {
		boolean removed = tasks.removeIf(t -> t.getTaskId().equals(taskId));
		if (!removed) {
			throw new NoSuchElementException(TASK_NOT_FOUND);
		}
	}

	public Task findTask(String taskId) {
		for (Task t : tasks) {
			if (t.getTaskId().equals(taskId)) {
				return t;
			}
		}
		return null;
	}
	
}
