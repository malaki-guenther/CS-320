package services;
/**
 * Contact.java
 * Represents a single contact with immutable ID and mutable personal details.
 * All fields are validated at construction and on update according to the project spec.
 */
public class Contact {
    // Contact ID is final – cannot be changed after creation
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Constructor – validates every parameter before storing.
     *
     * @param contactId Unique ID, max 10 chars, not null/empty
     * @param firstName First name, max 10 chars, not null
     * @param lastName  Last name, max 10 chars, not null
     * @param phone     Exactly 10 digits, not null
     * @param address   Max 30 chars, not null
     */
    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {

        // ---- Contact ID validation ----
        if (contactId == null || contactId.isEmpty() || contactId.length() > 10) {
            throw new IllegalArgumentException(
                "Contact ID must be non-null, non-empty, and <= 10 characters.");
        }

        // ---- First name validation ----
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                "First name must be non-null and <= 10 characters.");
        }

        // ---- Last name validation ----
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                "Last name must be non-null and <= 10 characters.");
        }

        // ---- Phone validation (exactly 10 digits) ----
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                "Phone must be exactly 10 digits.");
        }

        // ---- Address validation ----
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                "Address must be non-null and <= 30 characters.");
        }

        // All validations passed – assign fields
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.phone     = phone;
        this.address   = address;
    }

    // ------------------- Getters -------------------
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getPhone()     { return phone; }
    public String getAddress()   { return address; }

    // ------------------- Setters (only mutable fields) -------------------
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                "First name must be non-null and <= 10 characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                "Last name must be non-null and <= 10 characters.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                "Phone must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                "Address must be non-null and <= 30 characters.");
        }
        this.address = address;
    }
}