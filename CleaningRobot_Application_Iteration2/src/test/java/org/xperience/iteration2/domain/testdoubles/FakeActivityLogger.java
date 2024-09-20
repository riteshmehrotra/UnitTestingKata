package org.xperience.iteration2.domain.testdoubles;

import org.xperience.iteration2.domain.entities.logging.ForLoggingActivities;
import org.xperience.iteration2.domain.entities.logging.LogEntry;
import org.xperience.iteration2.domain.entities.logging.LogEvent;

import java.util.ArrayList;
import java.util.List;

public class FakeActivityLogger implements ForLoggingActivities {
    private final List<LogEntry> logEntries = new ArrayList<>();

    @Override
    public void log(LogEvent event, String details) {
        LogEntry entry = new LogEntry(event, details);
        logEntries.add(entry);
        System.out.println(entry);
    }

    @Override
    public List<LogEntry> getLogEntries() {
        return new ArrayList<>(logEntries);
    }

    @Override
    public void clearLogs() {
        logEntries.clear();
    }
}
