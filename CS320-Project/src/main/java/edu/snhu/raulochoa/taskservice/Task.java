package main.java.edu.snhu.raulochoa.taskservice;

public class Task {
	
	private static final int TASK_ID_MAX_LENGTH = 10;
	private static final int TASK_NAME_MAX_LENGTH = 20;
	private static final int TASK_DESCRIPTION_MAX_LENGTH = 50;
	
	private final String taskId;
    private String taskName;
    private String taskDescription;
    
    public Task(String taskId, String taskName, String taskDescription) {
        // Validate each field based on the assignment requirements
        if (taskId == null || taskId.length() > TASK_ID_MAX_LENGTH) {
        	throw new IllegalArgumentException("Task ID must be non-null and at most " + TASK_ID_MAX_LENGTH + " characters.");
        }
        
        // SINCE ITS FINAL, NO SETTER REQUIRED
        this.taskId = taskId;
        // CALL SETTERS TO AVOID DUPLICATE VALIDATION LOGIC
        setTaskName(taskName);
        setTaskDescription(taskDescription);
    }


	public String getTaskId() {
		return taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}


	public void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > TASK_NAME_MAX_LENGTH) {
        	throw new IllegalArgumentException("The Task Name must be non-null and at most " + TASK_NAME_MAX_LENGTH + " characters.");
        }
		this.taskName = taskName;
	}


	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > TASK_DESCRIPTION_MAX_LENGTH) {
        	throw new IllegalArgumentException("The Task Description must be non-null and at most " + TASK_DESCRIPTION_MAX_LENGTH + " characters.");
        }
		this.taskDescription = taskDescription;
	}
	
	
    
    

}
