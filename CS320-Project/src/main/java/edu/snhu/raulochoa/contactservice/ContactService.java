package main.java.edu.snhu.raulochoa.contactservice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ContactService {

	private static final String CONTACT_NOT_FOUND = "Contact ID was not found";
	private static final String DUPLICATE_CONTACT_ID = "Duplicate contact ID found";

	private final List<Contact> contacts = new ArrayList<>();

	public void addContact(Contact contact) {
		for (Contact c : contacts) {
			if (c.getContactId().equals(contact.getContactId())) {
				throw new IllegalArgumentException(DUPLICATE_CONTACT_ID);
			}
		}
		contacts.add(contact);
	}

	public void updateContact(Contact updatedcontact) {

		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getContactId().equals(updatedcontact.getContactId())) {
				contacts.set(i, updatedcontact);
				return;
			}
		}

		throw new NoSuchElementException(CONTACT_NOT_FOUND);

	}

	public void deleteContact(String contactId) {
		boolean removed = contacts.removeIf(c -> c.getContactId().equals(contactId));
		if (!removed) {
			throw new NoSuchElementException(CONTACT_NOT_FOUND);
		}
	}

	public Contact findContact(String contactId) {
		for (Contact c : contacts) {
			if (c.getContactId().equals(contactId)) {
				return c;
			}
		}
		return null;
	}
}
