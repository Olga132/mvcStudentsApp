package com.example.mvcstudentsapp.repositories;

import com.example.mvcstudentsapp.entities.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
