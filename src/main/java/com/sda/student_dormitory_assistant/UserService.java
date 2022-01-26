package com.sda.student_dormitory_assistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda.student_dormitory_assistant.security.User;
import com.sda.student_dormitory_assistant.security.UserRepository;


@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository repo;
     
    public void save(User user) {
        repo.save(user);
    }
    public User get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    }

    

