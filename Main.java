import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Create an account
        Account account = new Account("JohnDoe", "password123");
        System.out.println("Account created for: " + account.getAccName());

        // Create a timetable
        Timetable timetable = new Timetable();

        // Add events
        Event event1 = new Event(
            LocalDate.of(2025, 1, 15),
            LocalTime.of(9, 0),
            LocalTime.of(10, 0),
            "Morning Meeting",
            Priority.HIGH,
            RecurrenceType.NONE
        );

        Event event2 = new Event(
            LocalDate.of(2025, 1, 15),
            LocalTime.of(11, 0),
            LocalTime.of(12, 0),
            "Team Update",
            Priority.MEDIUM,
            RecurrenceType.NONE
        );

        Event conflictingEvent = new Event(
            LocalDate.of(2025, 1, 15),
            LocalTime.of(9, 30),
            LocalTime.of(10, 30),
            "Overlapping Meeting",
            Priority.LOW,
            RecurrenceType.NONE
        );

        System.out.println(timetable.addEvent(event1)); // Add event1
        System.out.println(timetable.addEvent(event2)); // Add event2

        // Attempt to add a conflicting event
        System.out.println(timetable.addEvent(conflictingEvent)); // Should detect conflict

        // Find free slots for the day
        System.out.println("Free slots on 2025-01-15:");
        timetable.findFreeSlots(LocalDate.of(2025, 1, 15)).forEach(System.out::println);

        // Display all events
        System.out.println("\nAll events in the timetable:");
        timetable.displayEvents();

        // Schedule recurring events
        Event recurringEvent = new Event(
            LocalDate.of(2025, 1, 16),
            LocalTime.of(14, 0),
            LocalTime.of(15, 0),
            "Recurring Meeting",
            Priority.HIGH,
            RecurrenceType.WEEKLY
        );
        System.out.println(timetable.addEvent(recurringEvent));

        System.out.println("\nRecurring events:");
        timetable.findFreeSlots(LocalDate.of(2025, 1, 30)).forEach(System.out::println);

        // Verify password for the account
        System.out.println("\nPassword verification:");
        System.out.println("Correct password: " + account.verifyPassword("password123")); // true
        System.out.println("Incorrect password: " + account.verifyPassword("wrongpassword")); // false
    }
}
