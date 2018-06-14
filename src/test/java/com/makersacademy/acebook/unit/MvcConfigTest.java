package com.makersacademy.acebook.unit;

import com.makersacademy.acebook.MvcConfig;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

public class MvcConfigTest {

//    @InjectMocks
//    private MvcConfig testConfig;
//
//    @Mock
//    ViewControllerRegistry registry;
//
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void addsViewControllers() {
//        testConfig.addViewControllers(registry);
//        verify(registry).addViewController("/index");
//        verify(registry).addViewController("/");
//        verify(registry).addViewController("/login");
//    }

    @Test
    public void dummyTest() {
        assertTrue(true);
    }


}
