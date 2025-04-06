package test.java.edu.snhu.raulochoa.contactservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.edu.snhu.raulochoa.contactservice.Contact;
import main.java.edu.snhu.raulochoa.contactservice.ContactService;

public class ContactServiceTest {

	private static final String VALID_ID = "001";
	private static final String VALID_FIRST_NAME = "Raul";
	private static final String VALID_LAST_NAME = "Ochoa";
	private static final String VALID_PHONE = "1234567890";
	private static final String VALID_ADDRESS = "111 Main St.";

	private ContactService service;

	@BeforeEach
	void setUp() {
		service = new ContactService();

	}

	@Test
	void testAddContact_withValidData_success() {
		// ARRANGE
		Contact contact = new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		// ACT
		service.addContact(contact);
		// ASSERT
		assertEquals(contact, service.findContact(VALID_ID));
	}

	@Test
	void testAddContact_withDuplicateId_throwsException() {
		// ARRANGE
		Contact contact = new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		Contact duplicate = new Contact("001", "Juan", "Abanto", "0987654321", "456 Elm St.");
		service.addContact(contact);
		// ACT AND ASSERT
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(duplicate);
		});
	}

	@Test
	void testDeleteContact_withExistingId_success() {
		// ARRANGE
		Contact contact = new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		service.addContact(contact);
		// ACT
		service.deleteContact(VALID_ID);
		// ASSERT
		assertNull(service.findContact(VALID_ID));
	}

	@Test
	void testDeleteContact_withNonexistentId_throwsException() {
		// ACT AND ASSERT
		assertThrows(NoSuchElementException.class, () -> service.deleteContact("999"));
	}

	@Test
	void testUpdateContact_withExistingId_Success() {
		// Arrange
		Contact originalContact = new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		service.addContact(originalContact);

		Contact updatedContact = new Contact(VALID_ID, "Luis", "Ochoa", "0987654321", "New Address");

		// Act
		service.updateContact(updatedContact);

		// Assert
		Contact retrieved = service.findContact(VALID_ID);
		assertEquals("Luis", retrieved.getFirstName());
		assertEquals("0987654321", retrieved.getPhone());
		assertEquals("New Address", retrieved.getAddress());
	}

	@Test
	void testUpdateContact_withNonexistentId_throwsException() {
		// Arrange
		Contact contact = new Contact("999", "NoneExist", "User", "1111111111", "Unknown Address");

		// Act & Assert
		assertThrows(NoSuchElementException.class, () -> service.updateContact(contact));
	}

}
