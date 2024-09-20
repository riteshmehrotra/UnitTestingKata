package domain;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.xperience.iteration1.domain.ForSettingSystemDateTime;
import org.xperience.iteration1.domain.entities.Robot;
import org.xperience.iteration1.domain.usecases.RobotController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GreetCustomerMockitoTests {

    @Test
    public void should_Greet_Customer_GoodMorning_UsingMockito(){
        String expectedGreeting = "Good Morning";
        ForSettingSystemDateTime locale = mock(ForSettingSystemDateTime.class);
        RobotController greeting = new RobotController(new Robot(locale));
        when(locale.get()).thenReturn(LocalDateTime.of(LocalDate.now(), LocalTime.of(10,0)));
        assertThat(greeting.start(), Matchers.is(Matchers.equalTo(expectedGreeting)));
    }
}
