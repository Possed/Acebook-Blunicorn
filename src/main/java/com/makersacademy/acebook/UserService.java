package com.makersacademy.acebook;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User findByUsername(String username);

    User save(UserRegistrationDto registration);
}
