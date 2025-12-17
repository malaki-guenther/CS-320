/**
 * ContactServiceTest.java
 * Unit tests for ContactService.
 * Verifies add, delete, update, and edge cases.
 */
package testCases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import services.Contact;
import services.ContactService;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact1;
    private Contact contact2;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        contact1 = new Contact("123", "Alice", "Smith", "5551234567", "789 Oak Ave");
        contact2 = new Contact("456", "Bob", "Jones", "5559876543", "321 Elm St");
    }

    @Test
    public void testAddContact() {
        assertTrue(service.addContact(contact1));
        assertEquals(1, service.getContactCount());
        assertEquals(contact1, service.getContact("123"));
    }

    @Test
    public void testAddDuplicateContact() {
        service.addContact(contact1);
        assertFalse(service.addContact(contact1));
        assertEquals(1, service.getContactCount());
    }

    @Test
    public void testAddNullContact() {
        assertFalse(service.addContact(null));
        assertEquals(0, service.getContactCount());
    }

    @Test
    public void testDeleteContact() {
        service.addContact(contact1);
        assertTrue(service.deleteContact("123"));
        assertEquals(0, service.getContactCount());
    }

    @Test
    public void testDeleteNonExistentContact() {
        assertFalse(service.deleteContact("999"));
    }

    @Test
    public void testUpdateContactFields() {
        service.addContact(contact1);
        assertTrue(service.updateContact("123", "Alicia", "Smithson",
                                        "5550001111", "999 Pine Rd"));

        Contact updated = service.getContact("123");
        assertEquals("Alicia", updated.getFirstName());
        assertEquals("Smithson", updated.getLastName());
        assertEquals("5550001111", updated.getPhone());
        assertEquals("999 Pine Rd", updated.getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        assertFalse(service.updateContact("999", "Name", "Last",
                                         "1234567890", "Addr"));
    }

    @Test
    public void testUpdateWithInvalidPhone() {
        service.addContact(contact1);
        assertFalse(service.updateContact("123", null, null, "123", null));
    }

    @Test
    public void testPartialUpdate() {
        service.addContact(contact1);
        assertTrue(service.updateContact("123", "NewFirst", null, null, null));
        Contact c = service.getContact("123");
        assertEquals("NewFirst", c.getFirstName());
        assertEquals("Smith", c.getLastName()); // unchanged
    }
}