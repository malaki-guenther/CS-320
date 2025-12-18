# CS-320


# Software Testing & Quality Assurance Portfolio

This repository showcases work from my coursework in software testing, automation, and quality assurance, highlighting skills in designing testable code, writing comprehensive unit tests, and applying effective testing strategies based on requirements.

## Submitted Files

### From Project One: Contact Service
- **Contact.java** – Contact class with immutable ID and strict validation on creation/updates.
- **ContactService.java** – In-memory service for adding, deleting, and updating contacts with unique ID enforcement.
- **ContactTest.java** – Tests all validation rules in the Contact class.
- **ContactServiceTest.java** – Covers add, delete, full/partial updates, duplicates, nulls, and invalid data.

All tests pass with high coverage of valid and edge cases.

### From Project Two
- **Final2ModSeven.docx** – Reflection on testing the full mobile app (contacts, tasks, appointments), including strategy, coverage, and lessons learned.

## Reflections

### How can I ensure that my code, program, or software is functional and secure?

I ensure functionality with requirement driven unit tests covering happy paths, errors, and boundaries, achieving 94–100% coverage. Security is addressed through early, strict input validation that rejects invalid data, preventing corruption or vulnerabilities.

### How do I interpret user needs and incorporate them into a program?

I translate requirements directly into code and tests, ensuring each constraint (e.g., lengths, uniqueness, date rules) becomes validation logic and corresponding test cases. Features like partial updates add real world flexibility while staying true to specifications.

### How do I approach designing software?

I prioritize simplicity, modularity, and testability, separating concerns, validating early, and using a black box, fault finding mindset with boundary analysis. Tests guide design, uncover assumptions quickly, and help produce clean, maintainable code that reliably meets requirements.

These projects taught me that disciplined testing and direct requirements traceability are key to building trustworthy software.
