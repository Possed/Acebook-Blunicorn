package com.makersacademy.acebook.unit;

import com.makersacademy.acebook.User;
import com.makersacademy.acebook.UserRegistrationDto;
import com.makersacademy.acebook.UserRepository;
import com.makersacademy.acebook.UserServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {


    private final String testEmail = "test@email.com";
    private final String testUsername = "username";
    private final String testPassword = "password";
    private final User testUser = new User(testUsername, testEmail, testPassword);

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    private UserRegistrationDto userDto;

    @Mock
    private User user;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
        when(userRepository.findByEmail(testEmail)).thenReturn(testUser);
        when(userRepository.findByUsername(testUsername)).thenReturn(testUser);
    }

    @Test
    public void findsByEmail() {
        assertEquals(testUser, userService.findByEmail(testEmail));
    }

    @Test
    public void findsByUsername() {
        assertEquals(testUser, userService.findByUsername(testUsername));
    }

    @Test
    public void savesUser() {
        userService.save(userDto);
        verify(userRepository).save(any(User.class));
    }

    @Test
    public void loadsUserByUsername() {
        when(userRepository.findByUsername(testUsername)).thenReturn(testUser);
        assertTrue(userService.loadUserByUsername(testUsername) instanceof org.springframework.security.core.userdetails.User);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void throwsErrorWhenUserWhenNotFound() {
        when(userRepository.findByUsername(testUsername)).thenReturn(null);
        exception.expect(UsernameNotFoundException.class);
        userService.loadUserByUsername(testUsername);
    }


}
