package com.sda.student_dormitory_assistant.security;

import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm {
    @NotBlank(message = "Enter your username")
    private String username;
    @NotBlank(message = "Enter your password")
    private String password;
    @NotBlank(message = "Enter your fullname")
    private String fullName;
    @NotBlank(message = "Enter your phone")
    private String phone;

    User toUser(PasswordEncoder encoder) {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(encoder.encode(this.password));
        user.setFullName(this.fullName);
        user.setPhone(this.phone);
        return user;
    }
}
