package test.java.edu.snhu.raulochoa.taskservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.java.edu.snhu.raulochoa.taskservice.Task;

public class TaskTest {

	@Test
	void testTaskCreation_withValidData_shouldSetAllFieldsCorrectly() {
		// ARRANGE
		Task task = new Task("1234567890", "Task Name", "Task description goes here.");
		// ACT AND ASSERT
		assertEquals("1234567890", task.getTaskId());
		assertEquals("Task Name", task.getTaskName());
		assertEquals("Task description goes here.", task.getTaskDescription());
	}

	@Test
	void testTaskCreation_withNullTasktId_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Task(null, "Task Name", "Task description goes here."));
	}

	@Test
	void testTaskCreation_withTaskIdTooLong_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Task("12345678901", "Task Name", "Task description goes here."));
	}


	@Test
	void testTaskCreation_withNullTaskName_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Task("1234567890", null, "Task description goes here."));
	}

	@Test
	void testTaskCreation_withTaskNameTooLong_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Task("1234567890", "This task name is way longer than 20 characters.", "Task description goes here."));
	}

	@Test
	void testTaskCreation_withTaskDescriptionTooLong_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Task("1234567890", "Task Name", "This is a very long task description that should not be longer than 50 characters."));
	}

	@Test
	void testTaskCreation_withNullTaskDescription_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Task("1234567890", "Task Name", null));
	}

}
