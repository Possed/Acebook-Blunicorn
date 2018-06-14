package com.makersacademy.acebook.integration;

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
        User firstUser = new User("firstUser", "firstUser@email.com", "password1" );
        entityManager.persist(firstUser);
        entityManager.flush();

        User testUser = userRepository.findByEmail(firstUser.getEmail());

        assertEquals(firstUser.getEmail(), testUser.getEmail());
    }

    @Test
    public void findsByUsername() {
        User firstUser = new User("firstUser", "firstUser@email.com", "password1");
        entityManager.persist(firstUser);
        entityManager.flush();

        User testUser = userRepository.findByUsername(firstUser.getUsername());
        assertEquals(firstUser.getEmail(),testUser.getEmail());
    }
}
