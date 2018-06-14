package com.makersacademy.acebook.unit;

import com.makersacademy.acebook.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UserTest {

    private final String username = "user";
    private final String email = "user@email.com";
    private final String password = "mypassword";
    private final Long id = Long.valueOf(123);

    private User user = new User(username, email, password);

    @Before
    public void setupUser() {
        user.setId(id);
    }

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

    @Test
    public void userHasId() { assertEquals(id, user.getId()); }

}
