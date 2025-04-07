package test.java.edu.snhu.raulochoa.taskservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.edu.snhu.raulochoa.taskservice.Task;
import main.java.edu.snhu.raulochoa.taskservice.TaskService;

public class TaskServiceTest {

	private static final String VALID_ID = "001";
	private static final String VALID_TASK_NAME = "Task Name";
	private static final String VALID_TASK_DESCRIPTION = "Task description goes here.";
	
	private TaskService service;
	
	@BeforeEach
	void setUp() {
		service = new TaskService();

	}
	
	@Test
	void testAddTask_withValidData_success() {
		// ARRANGE
		Task task = new Task(VALID_ID, VALID_TASK_NAME, VALID_TASK_DESCRIPTION);
		// ACT
		service.addTask(task);
		// ASSERT
		assertEquals(task, service.findTask(VALID_ID));
	}
	
	@Test
	void testAddTask_withDuplicateId_throwsException() {
		// ARRANGE
		Task task = new Task(VALID_ID, VALID_TASK_NAME, VALID_TASK_DESCRIPTION);
		Task duplicate = new Task("001", "Task Name 1", "Other task description.");
		service.addTask(task);
		// ACT AND ASSERT
		assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(duplicate);
		});
	}
	
	@Test
	void testDeleteTask_withExistingId_success() {
		// ARRANGE
		Task task = new Task(VALID_ID, VALID_TASK_NAME, VALID_TASK_DESCRIPTION);
		service.addTask(task);
		// ACT
		service.deleteTask(VALID_ID);
		// ASSERT
		assertNull(service.findTask(VALID_ID));
	}
	
	@Test
	void testDeleteTask_withNonexistentId_throwsException() {
		// ACT AND ASSERT
		assertThrows(NoSuchElementException.class, () -> service.deleteTask("999"));
	}
	
	@Test
	void testUpdateTask_withExistingId_Success() {
		// Arrange
		Task originalTask = new Task(VALID_ID, VALID_TASK_NAME, VALID_TASK_DESCRIPTION);
		service.addTask(originalTask);

		Task updatedTask = new Task(VALID_ID, "Test Task Name", "Test Task Description");

		// Act
		service.updateTask(updatedTask);

		// Assert
		Task retrieved = service.findTask(VALID_ID);
		assertEquals("Test Task Name", retrieved.getTaskName());
		assertEquals("Test Task Description", retrieved.getTaskDescription());
	}
	
	@Test
	void testUpdateTask_withNonexistentId_throwsException() {
		// Arrange
		Task task = new Task("999", "None Exist", "None Exist");

		// Act & Assert
		assertThrows(NoSuchElementException.class, () -> service.updateTask(task));
	}
}
