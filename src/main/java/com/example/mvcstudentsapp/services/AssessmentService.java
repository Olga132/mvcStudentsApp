package com.example.mvcstudentsapp.services;

import com.example.mvcstudentsapp.entities.Assessment;
import com.example.mvcstudentsapp.repositories.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//    @Query(value = "SELECT ass.subject_id, AVG(ass.assessment) FROM assessment_t ass WHERE ass.student_id = ?1 group by ass.subject_id" , nativeQuery = true)
//    public void getAverageScoreInSubjects(Integer studentId){
//
//    }

//    @Query("SELECT AVG(ass.assessment) from Assessment ass where ass.student.id=:studentId")
//    public double findAverageScoreStudent(@Param("studentId") long studentId){
//        return
//    }

    public List<Assessment> findAllStudentGrades(long studentId){
        List<Assessment> ass = (List<Assessment>) assessmentRepository.findAll();
        List<Assessment> result = new ArrayList<>();
        for (Assessment a: ass
             ) {
            if(a.getStudent().getId() == studentId){
                result.add(a);
            }
        }

        return result;

    }
}
