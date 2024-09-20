package org.xperience.iteration2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xperience.iteration2.domain.entities.cleaning.Robot;
import org.xperience.iteration2.domain.entities.logging.LogEvent;
import org.xperience.iteration2.domain.testdoubles.FakeActivityLogger;
import org.xperience.iteration2.domain.entities.logging.ForLoggingActivities;
import org.xperience.iteration2.domain.entities.logging.LogEntry;
import org.xperience.iteration2.domain.testdoubles.StubbedDateTimeProvider;
import org.xperience.iteration2.domain.testdoubles.StubbedMapProvider;
import org.xperience.iteration2.domain.usecases.RobotController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FakeActivityLoggerTests {

    ForSettingSystemDateTime dateTimeProvider;
    Robot robot;
    RobotController robotController;
    ForLoggingActivities activityLogger;

    @BeforeEach
    public void setup() {
        dateTimeProvider = new StubbedDateTimeProvider(
                LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0)));
        activityLogger = new FakeActivityLogger();
        robot = new Robot(dateTimeProvider, activityLogger);
        robotController = RobotController.builder()
                .robot(robot)
                .mapProvider(new StubbedMapProvider())
                .build();
    }

    @Test
    public void should_have_no_entries_if_robot_is_off() {
        List<LogEntry> logs = activityLogger.getLogEntries();
        assertThat(logs.isEmpty(), is(equalTo(true)));
    }


    @Test
    public void should_have_start_entry_when_robot_is_started() {
        robot.start();
        List<LogEntry> logs = activityLogger.getLogEntries();
        LogEntry startLog = logs.get(0);
        assertThat(startLog.getEvent(), is(equalTo(LogEvent.START)));
    }
}
