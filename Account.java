import java.util.ArrayList;

public class Account {
    private String accName;
    private String password;
    private ArrayList<Event> events;

    public Account(String accName, String password) {
        this.accName = accName;
        this.password = hashPassword(password);
        this.events = new ArrayList<>();
    }

    // Password hashing (SHA-256)
    private String hashPassword(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(hashPassword(inputPassword));
    }

    // Add an event
    public String scheduleEvent(Event event) {
        for (Event e : events) {
            if (e.checkOverlap(event)) {
                return "Conflict with existing event: " + e;
            }
        }
        events.add(event);
        return "Event scheduled successfully.";
    }

    // Delete an event
    public String deleteEvent(Event event) {
        if (events.remove(event)) {
            return "Event deleted successfully.";
        }
        return "Event not found.";
    }

    // Get all events
    public ArrayList<Event> getEvents() {
        return events;
    }

    public String getAccName() {
        return accName;
    }
}