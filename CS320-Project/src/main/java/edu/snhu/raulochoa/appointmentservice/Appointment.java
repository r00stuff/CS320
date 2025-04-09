package main.java.edu.snhu.raulochoa.appointmentservice;

import java.util.Date;

public class Appointment {

	private static final int APPOINTMENT_ID_MAX_LENGTH = 10;
	private static final int APPOINTMENT_DESCRIPTION_MAX_LENGTH = 50;
	
	private final String appointmentId; // Made it final to make it not updatable
	private String appointmentDescription;
	private Date appointmentDate;
	
	
	public Appointment(String appointmentId, String appointmentDescription, Date appointmentDate) {
        // Validate each field based on the assignment requirements provided
        if (appointmentId == null || appointmentId.length() > APPOINTMENT_ID_MAX_LENGTH) {
        	throw new IllegalArgumentException("Appointment ID must be non-null and at most " + APPOINTMENT_ID_MAX_LENGTH + " characters.");
        }
        
        // SINCE ITS FINAL, NO SETTER REQUIRED
        this.appointmentId = appointmentId;
        // CALL SETTERS TO AVOID DUPLICATE VALIDATION LOGIC
        setAppointmentDescription(appointmentDescription);
        setAppointmentDate(appointmentDate);
    }
	
	// Getters
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	
	
	// Setters - No setter for appointmentId since we do not want it to be editable
	public void setAppointmentDate(Date appointmentDate) {
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment date must be non-null and not be in the past.");
		}
		this.appointmentDate = appointmentDate;
	}
	
	public void setAppointmentDescription(String appointmentDescription) {
		if (appointmentDescription == null || appointmentDescription.length() > APPOINTMENT_DESCRIPTION_MAX_LENGTH) {
			throw new IllegalArgumentException("Appointment description must be not-null and at most " + APPOINTMENT_DESCRIPTION_MAX_LENGTH + " characters.");
		}
		this.appointmentDescription = appointmentDescription;
	}
	
}
