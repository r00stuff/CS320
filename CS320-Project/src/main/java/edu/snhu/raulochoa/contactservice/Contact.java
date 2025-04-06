package main.java.edu.snhu.raulochoa.contactservice;


public class Contact {
	
	private static final int CONTACT_ID_MAX_LENGTH = 10;
	private static final int NAME_MAX_LENGTH = 10;
	private static final int PHONE_LENGTH = 10;
	private static final int ADDRESS_MAX_LENGTH = 30;
	private static final String PHONE_REGEX = "\\d{10}";
	
    private final String contactId; // Made it final to make it not updatable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    
    

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate each field based on the assignment requirements
        if (contactId == null || contactId.length() > CONTACT_ID_MAX_LENGTH) {
        	throw new IllegalArgumentException("Contact ID must be non-null and at most " + CONTACT_ID_MAX_LENGTH + " characters.");
        }
        
        // SINCE ITS FINAL, NO SETTER REQUIRED
        this.contactId = contactId;
        // CALL SETTERS TO AVOID DUPLICATE VALIDATION LOGIC
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // These are the Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // These are the Setters, except for contactId since we do not want to make it updatable
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > NAME_MAX_LENGTH) {
        	throw new IllegalArgumentException("First name must be non-null and at most " + NAME_MAX_LENGTH + " characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > NAME_MAX_LENGTH) {
        	throw new IllegalArgumentException("Last name must be non-null and at most " + NAME_MAX_LENGTH + " characters.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches(PHONE_REGEX)) {
        	throw new IllegalArgumentException("Phone must be non-null and at most " + PHONE_LENGTH + " characters.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > ADDRESS_MAX_LENGTH) {
        	throw new IllegalArgumentException("Address must be non-null and at most " + ADDRESS_MAX_LENGTH + " characters.");
        }
        this.address = address;
    }
}
