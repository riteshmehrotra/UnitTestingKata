package org.xperience.iteration2.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xperience.iteration2.domain.entities.cleaning.Robot;
import org.xperience.iteration2.domain.testdoubles.DummyActivityLogger;
import org.xperience.iteration2.domain.testdoubles.StubbedDateTimeProvider;
import org.xperience.iteration2.domain.usecases.RobotController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class StartStopRobotTests {

    ForSettingSystemDateTime dateTimeProvider;

    @BeforeEach
    public void setup() {
        dateTimeProvider = new StubbedDateTimeProvider(
                LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0)));
    }


    @Test
    public void should_greet_customer_goodMorning_on_start() {
        String expectedGreeting = "Good Morning";
        Robot robot = new Robot(dateTimeProvider, new DummyActivityLogger());
        RobotController robotController = RobotController.builder().robot(robot).build();
        assertThat(robotController.start(), is(equalTo(expectedGreeting)));
    }

}
