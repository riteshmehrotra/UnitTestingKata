package org.xperience.iteration2.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xperience.iteration2.domain.entities.cleaning.CleaningMode;
import org.xperience.iteration2.domain.entities.cleaning.Robot;
import org.xperience.iteration2.domain.exceptions.SpaceMapNotFoundException;
import org.xperience.iteration2.domain.testdoubles.*;
import org.xperience.iteration2.domain.usecases.RobotController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CleaningWithProvidedMapsTest {

    ForSettingSystemDateTime dateTimeProvider;
    Robot robot;

    @BeforeEach
    public void setup() {
        dateTimeProvider = new StubbedDateTimeProvider(
                LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0)));
        robot = new Robot(dateTimeProvider, new DummyActivityLogger());
    }

    @Test
    public void should_start_cleaning_when_map_is_available() {
        RobotController robotController = RobotController.builder()
                .robot(robot)
                .mapProvider(new StubbedMapProvider())
                .build();
        robotController.start();

        String bedroom = "Bedroom";
        CleaningMode dummy = new DummyCleaningMode();

        robotController.clean(bedroom, dummy);
        assertThat(robot.getCurrentState(), is(equalTo(RobotState.CLEANING)));
    }


    @Test
    public void should_throw_exception_when_map_is_not_available() {
        RobotController robotController = RobotController.builder()
                .robot(robot)
                .mapProvider(new StubbedMapExceptionProvider())
                .build();
        robotController.start();

        String kitchen = "kitchen";
        CleaningMode dummy = new DummyCleaningMode();

        assertThrows(SpaceMapNotFoundException.class, () ->
                robotController.clean(kitchen, dummy));
    }

}
