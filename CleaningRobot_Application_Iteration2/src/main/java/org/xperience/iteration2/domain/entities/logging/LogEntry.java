package org.xperience.iteration2.domain.entities.logging;

public class LogEntry {
    private final LogEvent event;
    private final String details;
    private final long timestamp;

    public LogEntry(LogEvent event, String details) {
        this.event = event;
        this.details = details;
        this.timestamp = System.currentTimeMillis();
    }

    public LogEvent getEvent() {
        return event;
    }

    public String getDetails() {
        return details;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s: %s", timestamp, event, details);
    }
}
