package com.example.mvcstudentsapp.repositories;

import com.example.mvcstudentsapp.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
