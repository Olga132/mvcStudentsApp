package com.example.mvcstudentsapp.repositories;

import com.example.mvcstudentsapp.entities.Assessment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends CrudRepository<Assessment, Long> {
}
