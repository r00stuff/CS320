package test.java.edu.snhu.raulochoa.contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.java.edu.snhu.raulochoa.contactservice.Contact;

public class ContactTest {

	@Test
	void testContactCreation_withValidData_shouldSetAllFieldsCorrectly() {
		// ARRANGE
		Contact contact = new Contact("1234567890", "Raul", "Ochoa", "1234567890", "111 Main St.");
		// ACT AND ASSERT
		assertEquals("1234567890", contact.getContactId());
		assertEquals("Raul", contact.getFirstName());
		assertEquals("Ochoa", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("111 Main St.", contact.getAddress());
	}

	@Test
	void testContactCreation_withNullContactId_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact(null, "Raul", "Ochoa", "1234567890", "111 Main St."));
	}

	@Test
	void testContactCreation_withContactIdTooLong_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("12345678901", "Raul", "Ochoa", "1234567890", "111 Main St."));
	}


	@Test
	void testContactCreation_withNullFirstName_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1234567890", null, "Ochoa", "1234567890", "111 Main St."));
	}

	@Test
	void testContactCreation_withFirstNameTooLong_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1234567890", "RaulRaulRaul", "Ochoa", "1234567890", "111 Main St."));
	}

	@Test
	void testContactCreation_withLastNameTooLong_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1234567890", "Raul", "OchoaOchoaOchoa", "1234567890", "111 Main St."));
	}

	@Test
	void testContactCreation_withNullLastName_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1234567890", "Raul", null, "1234567890", "111 Main St."));
	}

	@Test
	void testContactCreation_withPhoneNumberNotExactly10Digits_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1234567890", "Raul", "Ochoa", "12345", "111 Main St."));
	}

	@Test
	void testContactCreation_withNullPhoneNumber_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1234567890", "Raul", "Ochoa", null, "111 Main St."));
	}

	@Test
	void testContactCreation_withNullAddress_shouldThrowException() {
		assertThrows(IllegalArgumentException.class,
				() -> new Contact("1234567890", "Raul", "Ochoa", "1234567890", null));
	}
}
