package test.java.edu.snhu.raulochoa.appointmentservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

import main.java.edu.snhu.raulochoa.appointmentservice.Appointment;
import main.java.edu.snhu.raulochoa.appointmentservice.AppointmentService;
import main.java.edu.snhu.raulochoa.contactservice.Contact;
import main.java.edu.snhu.raulochoa.contactservice.ContactService;

public class AppointmentServiceTest {

	private static final String VALID_ID = "001";
	private static final String VALID_APPOINTMENT_DESCRIPTION = "This is the appointment description.";
	private static final Date VALID_APPOINTMENT_FUTURE_DATE;

	private AppointmentService service;

	// Static block to initialize the static Date
	static {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1); // 1 day in the future
		VALID_APPOINTMENT_FUTURE_DATE = calendar.getTime();
	}

	@BeforeEach
	void setUp() {
		service = new AppointmentService();

	}

	@Test
	void testAddAppointment_withValidData_success() {
		// ARRANGE
		Appointment appointment = new Appointment(VALID_ID, VALID_APPOINTMENT_DESCRIPTION,
				VALID_APPOINTMENT_FUTURE_DATE);
		// ACT
		service.addAppointment(appointment);
		// ASSERT
		assertEquals(appointment, service.findAppointment(VALID_ID));
	}
	
	@Test
	void testAddAppointment_withDuplicateId_throwsException() {
		// ARRANGE
		Appointment appointment = new Appointment(VALID_ID, VALID_APPOINTMENT_DESCRIPTION, VALID_APPOINTMENT_FUTURE_DATE);
		Appointment duplicate = new Appointment("001", "This is the appointment description.", VALID_APPOINTMENT_FUTURE_DATE);
		service.addAppointment(appointment);
		// ACT AND ASSERT
		assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(duplicate);
		});
	}
	
	@Test
	void testDeleteAppointment_withExistingId_success() {
		// ARRANGE
		Appointment appointment = new Appointment(VALID_ID, VALID_APPOINTMENT_DESCRIPTION, VALID_APPOINTMENT_FUTURE_DATE);
		service.addAppointment(appointment);
		// ACT
		service.deleteAppointment(VALID_ID);
		// ASSERT
		assertNull(service.findAppointment(VALID_ID));
	}
	
	@Test
	void testDeleteAppointment_withNonexistentId_throwsException() {
		// ACT AND ASSERT
		assertThrows(NoSuchElementException.class, () -> service.deleteAppointment("999"));
	}
	
	

}
