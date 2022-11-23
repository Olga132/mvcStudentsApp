package com.example.mvcstudentsapp.services;

import com.example.mvcstudentsapp.entities.Assessment;
import com.example.mvcstudentsapp.entities.Subject;
import com.example.mvcstudentsapp.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;


    public List<Subject> getAll() {
        return (List<Subject>) subjectRepository.findAll();
    }


}
