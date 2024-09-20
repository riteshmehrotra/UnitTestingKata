package org.xperience.iteration2.domain.testdoubles;

import org.xperience.iteration2.domain.entities.logging.ForLoggingActivities;
import org.xperience.iteration2.domain.entities.logging.LogEntry;
import org.xperience.iteration2.domain.entities.logging.LogEvent;

import java.util.List;

public class DummyActivityLogger implements ForLoggingActivities {
    @Override
    public void log(LogEvent event, String details) {

    }

    @Override
    public List<LogEntry> getLogEntries() {
        return null;
    }

    @Override
    public void clearLogs() {

    }
}
