package com.makersacademy.acebook;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserRegistrationDto {

    @NotEmpty
    private String username;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

}
