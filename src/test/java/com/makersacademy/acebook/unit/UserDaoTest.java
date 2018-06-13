package com.makersacademy.acebook.unit;

import com.makersacademy.acebook.UserRegistrationDto;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class UserDaoTest {

    private UserRegistrationDto dto = new UserRegistrationDto();
    private UserRegistrationDto dto2 = new UserRegistrationDto();
    private final String testUsername = "testuser";
    private final String testEmail = "testEmail";
    private final String testPassword = "password";

    @Before
    public void initDto() {
        dto.setUsername(testUsername);
        dto.setEmail(testEmail);
        dto.setPassword(testPassword);
    }

    @Test
    public void hasUsername() {
        assertEquals(testUsername, dto.getUsername());
    }

    @Test
    public void hasEmail() {
        assertEquals(testEmail, dto.getEmail());
    }

    @Test
    public void hasPassword() {
        assertEquals(testPassword, dto.getPassword());
    }

    @Rule
    public final ExpectedException usernameException = ExpectedException.none();

    @Test
    public void validatesUsername() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserRegistrationDto>> constraintViolations = validator.validate(dto2);
        assertEquals(3, constraintViolations.size());
    }

    @Test
    public void validatesEmail() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        dto2.setEmail(testEmail);
        Set<ConstraintViolation<UserRegistrationDto>> constraintViolations = validator.validate(dto2);
        assertEquals(3, constraintViolations.size());
    }


}
