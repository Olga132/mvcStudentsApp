package com.example.mvcstudentsapp.services;

import com.example.mvcstudentsapp.entities.Assessment;
import com.example.mvcstudentsapp.entities.Student;
import com.example.mvcstudentsapp.repositories.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    AssessmentRepository assessmentRepository;


    public List<Assessment> listAllAssessment() {
        return (List<Assessment>) assessmentRepository.findAll();
    }

    public Assessment save(Assessment assessment){
        return assessmentRepository.save(assessment);
    }
}
