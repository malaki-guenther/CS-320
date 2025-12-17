/**
 * ContactService.java
 * In-memory contact management service.
 * Stores contacts in a HashMap keyed by contactId.
 * Provides add, delete, and field-update operations.
 */
package services;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Map of contactId -> Contact object (in-memory storage)
    private final Map<String, Contact> contacts;

    /** Default constructor – initializes empty map */
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    /**
     * Adds a contact if the ID is unique.
     *
     * @param contact the Contact object to add
     * @return true if added, false if contact is null or ID already exists
     */
    public boolean addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            return false; // duplicate or null
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    /**
     * Removes a contact by ID.
     *
     * @param contactId ID of contact to delete
     * @return true if removed, false if ID not found or null
     */
    public boolean deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            return false;
        }
        contacts.remove(contactId);
        return true;
    }

    /**
     * Updates any non-null fields of an existing contact.
     * Only provided fields are changed; others remain unchanged.
     *
     * @param contactId  ID of contact to update
     * @param firstName  new first name (or null to skip)
     * @param lastName   new last name (or null to skip)
     * @param phone      new phone (or null to skip)
     * @param address    new address (or null to skip)
     * @return true if update succeeded, false if contact not found or validation fails
     */
    public boolean updateContact(String contactId, String firstName,
                                 String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            return false; // contact not found
        }

        try {
            if (firstName != null) contact.setFirstName(firstName);
            if (lastName  != null) contact.setLastName(lastName);
            if (phone     != null) contact.setPhone(phone);
            if (address   != null) contact.setAddress(address);
            return true;
        } catch (IllegalArgumentException e) {
            return false; // validation error
        }
    }

    // ------------------- Helper methods for testing -------------------
    /** Returns contact by ID (used in tests) */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    /** Returns current number of stored contacts (used in tests) */
    public int getContactCount() {
        return contacts.size();
    }
}