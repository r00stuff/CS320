package main.java.edu.snhu.raulochoa.appointmentservice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class AppointmentService {
	
	private static final String APPOINTMENT_NOT_FOUND = "Appointment ID was not found";
	private static final String DUPLICATE_APPOINTMENT_ID = "Duplicate appointment ID found";

	private final List<Appointment> appointments = new ArrayList<>();

	public void addAppointment(Appointment appointment) {
		for (Appointment a : appointments) {
			if (a.getAppointmentId().equals(appointment.getAppointmentId())) {
				throw new IllegalArgumentException(DUPLICATE_APPOINTMENT_ID);
			}
		}
		appointments.add(appointment);
	}
	
	public void deleteAppointment(String appointmentId) {
		boolean removed = appointments.removeIf(a -> a.getAppointmentId().equals(appointmentId));
		if (!removed) {
			throw new NoSuchElementException(APPOINTMENT_NOT_FOUND);
		}
	}
	
	public Appointment findAppointment(String appointmentId) {
		for (Appointment a : appointments) {
			if (a.getAppointmentId().equals(appointmentId)) {
				return a;
			}
		}
		return null;
	}
	
}
