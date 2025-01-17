import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String description;
    private Priority priority;
    private RecurrenceType recurrence;

    public Event(LocalDate date, LocalTime startTime, LocalTime endTime, String description, Priority priority, RecurrenceType recurrence) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.priority = priority;
        this.recurrence = recurrence;
    }

    // Getters
    public LocalDate getDate() { return date; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public Priority getPriority() { return priority; }
    public RecurrenceType getRecurrence() { return recurrence; }

    // Check for overlapping events
    public boolean checkOverlap(Event other) {
        if (!this.date.equals(other.date)) return false;
        return this.startTime.isBefore(other.endTime) && this.endTime.isAfter(other.startTime);
    }

    // Generate recurring events
    public List<Event> generateRecurringEvents(LocalDate endDate) {
        List<Event> recurringEvents = new ArrayList<>();
        LocalDate nextDate = this.date;

        while (!nextDate.isAfter(endDate)) {
            recurringEvents.add(new Event(nextDate, startTime, endTime, description, priority, RecurrenceType.NONE));
            if (recurrence == RecurrenceType.DAILY) nextDate = nextDate.plusDays(1);
            else if (recurrence == RecurrenceType.WEEKLY) nextDate = nextDate.plusWeeks(1);
            else if (recurrence == RecurrenceType.MONTHLY) nextDate = nextDate.plusMonths(1);
            else break;
        }
        return recurringEvents;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return String.format("Event on %s from %s to %s: %s [Priority: %s, Recurrence: %s]",
                date.format(dateFormatter), startTime.format(timeFormatter), endTime.format(timeFormatter),
                description, priority, recurrence);
    }
}

// Enum for priority levels
enum Priority {
    HIGH, MEDIUM, LOW
}

// Enum for recurrence types
enum RecurrenceType {
    NONE, DAILY, WEEKLY, MONTHLY
}
