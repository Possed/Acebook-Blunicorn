package com.makersacademy.acebook.unit;

import com.makersacademy.acebook.DatabaseLoader;
import com.makersacademy.acebook.PostRepository;
import com.makersacademy.acebook.User;
import com.makersacademy.acebook.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

public class DatabaseLoaderTest {

    @InjectMocks
    DatabaseLoader testLoader;

    @Mock
    PostRepository postRepo;

    @Mock
    UserRepository userRepo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deletesPostData(){
        try {
            testLoader.run("Something");
        }
        catch (Exception err) {}
        Mockito.verify(postRepo).deleteAll();
    }

    @Test
    public void deletesUserData(){
        try {
            testLoader.run("Something");
        }
        catch (Exception err) {}
        Mockito.verify(userRepo).deleteAll();
    }

    @Test
    public void savesUserData(){
        try {
            testLoader.run("Something");
        }
        catch (Exception err) {}
        Mockito.verify(userRepo).save(any(User.class));
    }



}
