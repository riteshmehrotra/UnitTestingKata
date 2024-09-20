package org.xperience.baseversion.domain;

import org.junit.jupiter.api.Test;
import org.xperience.baseversion.domain.usecases.StartRobotUseCase;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class GreetCustomerTests {
    //Flaky test
    @Test
    public void should_Greet_Customer_AsPer_TimeOfDay(){
        String expectedGreeting = "Good Morning";
        StartRobotUseCase greeting = new StartRobotUseCase();
        assertThat(greeting.start(), is(equalTo(expectedGreeting)));
    }
}
