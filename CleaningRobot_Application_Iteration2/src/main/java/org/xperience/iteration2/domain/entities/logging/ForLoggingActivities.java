package org.xperience.iteration2.domain.entities.logging;

import java.util.List;

public interface ForLoggingActivities {
    void log(LogEvent event, String details);
    List<LogEntry> getLogEntries();
    void clearLogs();
}
