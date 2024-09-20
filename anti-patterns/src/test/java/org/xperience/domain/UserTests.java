package org.xperience.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.xperience.domain.User;

public class UserTests {

    @Test
    public void should_instantiate_User(){
        User user = new User();
        assertNotNull(user);
    }

    @Test
    public void should_set_username() {
        User user = new User();
        user.setUsername("new_username");
        assertEquals("new_username", user.getUsername());
    }
}
