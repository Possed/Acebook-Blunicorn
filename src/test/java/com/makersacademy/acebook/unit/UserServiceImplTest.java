package com.makersacademy.acebook.unit;

import com.makersacademy.acebook.User;
import com.makersacademy.acebook.UserRepository;
import com.makersacademy.acebook.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {


    private final String testEmail = "testEmail";

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock User user = new User("testuser", "test@emial.com", "password");

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void findsByEmail() {
        when(userRepository.findByEmail(testEmail)).thenReturn(user);

        assertEquals(user, userService.findByEmail(testEmail));

    }

    @Test
    public void savesUser() {
        
    }


}
