package com.makersacademy.integration;

import com.makersacademy.acebook.User;
import com.makersacademy.acebook.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findsByEmail() {
        User firstUser = new User();
        firstUser.setUsername("firstUser");
        firstUser.setEmail("firstUser@email.com");
        firstUser.setPassword("password1");
        entityManager.persist(firstUser);
        entityManager.flush();

        User secondUser = new User();
        firstUser.setUsername("secondUser");
        firstUser.setEmail("secondUser@email.com");
        firstUser.setPassword("password2");
        entityManager.persist(secondUser);
        entityManager.flush();

        List<User> users = userRepository.findAll();

        assertEquals(2, users.size());


    }

    @Test
    public void findsByUsername() {

    }


}
