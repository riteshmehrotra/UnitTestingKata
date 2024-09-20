package org.xperience.iteration2.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xperience.iteration2.domain.entities.cleaning.*;
import org.xperience.iteration2.domain.testdoubles.*;
import org.xperience.iteration2.domain.usecases.RobotController;
import org.xperience.iteration2.ports.ForFetchingSpaceMap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CleaningWithDifferentCleaningModesTests {

    ForSettingSystemDateTime dateTimeProvider;
    Robot robot;
    RobotController robotController;

    @BeforeEach
    public void setup() {
        dateTimeProvider = new StubbedDateTimeProvider(
                LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0)));
        robot = new Robot(dateTimeProvider, new DummyActivityLogger());
        robotController = RobotController.builder()
                .robot(robot)
                .mapProvider(new StubbedMapProvider())
                .build();
        robotController.start();

    }

    @Test
    public void should_clean_once_with_defaultMode() {
        ForFetchingSpaceMap spaceMap = new StubbedMapProvider();

        String bedroom = "Bedroom";
        SpySweepingBehaviour spySweepingBehaviour = new SpySweepingBehaviour();
        CleaningMode mode = new DefaultCleaningMode();
        mode.setBehaviours(List.of(spySweepingBehaviour));
        robotController.clean(bedroom, mode);

        assertThat(spySweepingBehaviour.timesCalled(), is(equalTo(1)));
        assertThat(spySweepingBehaviour.calledWith(spaceMap.fetch("Bedroom")), is(equalTo(true)));
    }


    @Test
    public void should_clean_twice_with_deepCleaningMode() {
        ForFetchingSpaceMap spaceMap = new StubbedMapProvider();

        String bedroom = "Bedroom";
        SpySweepingBehaviour spySweepingBehaviour = new SpySweepingBehaviour();
        SpyMoppingBehaviour spyMoppingBehaviour = new SpyMoppingBehaviour();
        CleaningMode mode = new DeepCleaningMode();
        mode.setBehaviours(List.of(spySweepingBehaviour,spyMoppingBehaviour));
        robotController.clean(bedroom, mode);

        assertThat(spySweepingBehaviour.timesCalled(), is(equalTo(2)));
        assertThat(spySweepingBehaviour.calledWith(spaceMap.fetch("Bedroom")), is(equalTo(true)));
        assertThat(spyMoppingBehaviour.timesCalled(), is(equalTo(2)));
        assertThat(spyMoppingBehaviour.calledWith(spaceMap.fetch("Bedroom")), is(equalTo(true)));
    }


    @Test
    public void should_sweep_once_with_defaultMode_Mock() {
        ForFetchingSpaceMap spaceMap = new StubbedMapProvider();

        String bedroom = "Bedroom";
        MockSweepingBehaviour mockSweepingBehaviour = new MockSweepingBehaviour();
        CleaningMode mode = new DefaultCleaningMode();
        mode.setBehaviours(List.of(mockSweepingBehaviour));
        robotController.clean(bedroom, mode);

       mockSweepingBehaviour.verify(1,spaceMap.fetch(bedroom));
    }



}
