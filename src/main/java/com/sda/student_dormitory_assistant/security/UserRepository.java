package com.sda.student_dormitory_assistant.security;

import com.sda.student_dormitory_assistant.security.User.Role;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);
    public User findByRole(Role role);

}

