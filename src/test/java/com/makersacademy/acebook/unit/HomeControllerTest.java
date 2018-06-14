package com.makersacademy.acebook.unit;

import com.makersacademy.acebook.HomeController;
import com.makersacademy.acebook.User;
import com.makersacademy.acebook.UserRegistrationDto;
import com.makersacademy.acebook.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    UserService userService;

    @MockBean
    private HomeController homeController;

    @Mock
    UserRegistrationDto dto;

    @Mock
    Model model;

    @Mock
    User user;

    @Mock
    BindingResult result;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void runsIndex(){
        when(homeController.index()).thenCallRealMethod();
        assertEquals("index", homeController.index());
    }

    @Test
    public void getsRegistration() {
       when(homeController.registration(any(Model.class))).thenCallRealMethod();
       assertEquals("register", homeController.registration(model));
    }

    @Test
    public void registersUser() {
        HomeController testHomeController = new HomeController(userService);
        when(userService.findByEmail(any())).thenReturn(null);
        String resultString = testHomeController.registrationUser(dto, result);
        verify(userService).save(dto);
        assertEquals("redirect:/users?success", resultString);
    }

    @Test
    public void redirectsToRegister() {
        HomeController testHomeController2 = new HomeController(userService);
        when(userService.findByEmail(any())).thenReturn(null);
        when(result.hasErrors()).thenReturn(true);
        assertEquals("register", testHomeController2.registrationUser(dto, result));
    }

    @Test
    public void returnsErrorIfUserExists() {
        HomeController testHomeController3 = new HomeController(userService);
        User testUser = new User();
        when(userService.findByEmail(any())).thenReturn(testUser);
        testHomeController3.registrationUser(dto, result);
        verify(result).rejectValue("email", null, "There is already an account registered with that email");
    }


}
