import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Timetable {
    private Map<LocalDate, List<Event>> eventsByDate;

    public Timetable() {
        eventsByDate = new HashMap<>();
    }

    // Add an event
    public boolean addEvent(Event event) {
        eventsByDate.computeIfAbsent(event.getDate(), k -> new ArrayList<>());
        List<Event> eventsOnDate = eventsByDate.get(event.getDate());

        for (Event e : eventsOnDate) {
            if (e.checkOverlap(event)) {
                System.out.println("Conflict detected with event: " + e);
                return false;
            }
        }
        eventsOnDate.add(event);
        System.out.println("Event added successfully.");
        return true;
    }

    // Find free slots on a specific date
    public List<String> findFreeSlots(LocalDate date) {
        List<String> freeSlots = new ArrayList<>();
        List<Event> eventsOnDate = eventsByDate.getOrDefault(date, new ArrayList<>());

        // Sort events by start time
        eventsOnDate.sort((e1, e2) -> e1.getStartTime().compareTo(e2.getStartTime()));

        LocalTime startOfDay = LocalTime.of(0, 0);
        LocalTime endOfDay = LocalTime.of(23, 59);

        // Detect gaps between events
        for (Event e : eventsOnDate) {
            if (startOfDay.isBefore(e.getStartTime())) {
                freeSlots.add(startOfDay + " - " + e.getStartTime());
            }
            startOfDay = e.getEndTime();
        }

        // Add the remaining slot after the last event
        if (startOfDay.isBefore(endOfDay)) {
            freeSlots.add(startOfDay + " - " + endOfDay);
        }

        return freeSlots;
    }

    // Display all events
    public void displayEvents() {
        for (Map.Entry<LocalDate, List<Event>> entry : eventsByDate.entrySet()) {
            System.out.println("Date: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}