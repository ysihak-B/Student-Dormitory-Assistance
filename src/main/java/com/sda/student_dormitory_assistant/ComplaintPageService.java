package com.sda.student_dormitory_assistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ComplaintPageService {
    
    @Autowired
    private ComplainRepository repo;

    public List<ComplainReport> listAll() {
        return (List<ComplainReport>) repo.findAll();
    }
     
    public void save(ComplainReport complainReport) {
        repo.save(complainReport);
    }
     
    public ComplainReport get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    }

    

