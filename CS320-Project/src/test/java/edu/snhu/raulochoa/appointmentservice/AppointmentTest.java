package test.java.edu.snhu.raulochoa.appointmentservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

import main.java.edu.snhu.raulochoa.appointmentservice.Appointment;

public class AppointmentTest {
	

	@Test
	void testAppointmentCreation_withValidData_shouldSetAllFieldsCorrectly() {
		// ARRANGE
		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1); // set to 1 day in the future
        Date futureDate = calendar.getTime();
        
		Appointment appointment = new Appointment("1234567890", "This is the appointment description.", futureDate);
		
		// ACT AND ASSERT
		assertEquals("1234567890", appointment.getAppointmentId());
		assertEquals("This is the appointment description.", appointment.getAppointmentDescription());
		assertEquals(futureDate, appointment.getAppointmentDate());
	}
	
	@Test
	void testAppointmentCreation_withNullAppointmentId_shouldThrowException() {
		// Arrange a valid future date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = calendar.getTime();
		
        // Act & Assert
		assertThrows(IllegalArgumentException.class,
				() -> new Appointment(null, "This is the appointment description.", futureDate));
	}
	
	@Test
	void testAppointmentCreation_withAppointmentIdTooLong_shouldThrowException() {
		// Arrange a valid future date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = calendar.getTime();
		
		assertThrows(IllegalArgumentException.class,
				() -> new Appointment("12345678901", "This is the appointment description.", futureDate));
	}
	
	@Test
	void testAppointmentCreation_withNullAppointmentDescription_shouldThrowException() {
		// Arrange a valid future date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = calendar.getTime();
        
		assertThrows(IllegalArgumentException.class,
				() -> new Appointment("1234567890", null, futureDate));
	}
	
	@Test
	void testAppointmentCreation_withAppointmentDescriptionTooLong_shouldThrowException() {
		// Arrange a valid future date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date futureDate = calendar.getTime();
        
		assertThrows(IllegalArgumentException.class,
				() -> new Appointment("1234567890", "This is the appointment description and it is longer than 50 characters.", futureDate));
	}
	
	@Test
	void testAppointmentCreation_withNullAppointmentDate_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Appointment("1234567890", "This is the appointment description.", null));
	}
	
	@Test
	void testAppointmentCreation_withAppointmentDateInPast_shouldThrowException() {
		// Arrange a past date
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date pastDate = calendar.getTime();
        
		assertThrows(IllegalArgumentException.class,
				() -> new Appointment("1234567890", "This is the appointment description.", pastDate));
	}
	
}
