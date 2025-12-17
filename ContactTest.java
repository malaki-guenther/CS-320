/**
 * ContactTest.java
 * Unit tests for the Contact class.
 * Covers creation, validation rules, and field updates.
 */
package testCases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import services.Contact;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        // Arrange & Act
        Contact contact = new Contact("1234567890", "John", "Doe",
                                      "1234567890", "123 Main St");

        // Assert
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Johnnnnnnnnn", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", null, "1234567890", "123 Main St");
        });
    }

    @Test
    public void testPhoneNotTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "123", "123 Main St");
        });
    }

    @Test
    public void testAddressTooLong() {
        String longAddress = "1234567890123456789012345678901"; // 31 chars
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "John", "Doe", "1234567890", longAddress);
        });
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }
}