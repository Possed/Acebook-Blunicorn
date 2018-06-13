package com.makersacademy.unit;

import com.makersacademy.acebook.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserTest {

    private final String username = "user";
    private final String email = "user@email.com";
    private final String password = "mypassword";

    private User user = new User(username, email, password);

    @Test
    public void userHasUsername() {
        assertEquals(user.getUsername(), username);
    }

    @Test
    public void userHasEmail() {
        assertEquals(user.getEmail(), email);
    }

    @Test
    public void userHasPassword() {
        assertEquals(user.getPassword(), password);
    }

}
