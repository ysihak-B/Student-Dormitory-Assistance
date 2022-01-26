package com.sda.student_dormitory_assistant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComplainRepository extends CrudRepository<ComplainReport, Long>{
}
