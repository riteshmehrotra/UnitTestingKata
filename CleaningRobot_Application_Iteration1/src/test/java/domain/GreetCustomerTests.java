package domain;

import domain.testdoubles.StubbedDateTimeProvider;
import org.junit.jupiter.api.Test;
import org.xperience.iteration1.domain.ForSettingSystemDateTime;
import org.xperience.iteration1.domain.entities.Robot;
import org.xperience.iteration1.domain.usecases.RobotController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

public class GreetCustomerTests {

    @Test
    public void should_Greet_Customer_GoodMorning_OnStart() {
        String expectedGreeting = "Good Morning";
        ForSettingSystemDateTime dateTimeProvider = new StubbedDateTimeProvider(
                LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0)));
        Robot robot = new Robot(dateTimeProvider);
        RobotController greeting = new RobotController(robot);
        assertThat(greeting.start(), is(equalTo(expectedGreeting)));
    }

}
