package com.example.mvcstudentsapp.services;

import com.example.mvcstudentsapp.entities.Student;
import com.example.mvcstudentsapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentDAO;

    public List<Student> getAll(){
        return (List<Student>)studentDAO.findAll();
    }

    public Student save(Student student){
        return studentDAO.save(student);
    }

//    public void deleteById(Long id){
//        studentDAO.deleteById(id);
//    }

    // удаления студента по id
    public void deleteById(Long id) {
        // 1. найти студента для удаления
        Optional<Student> deleted = studentDAO.findById(id);
        // 2. если такой студент есть, то удалить его
        deleted.ifPresent(student -> studentDAO.delete(student));
    }

    public Optional<Student> getById(Long id){
        return studentDAO.findById(id);
    }
}
