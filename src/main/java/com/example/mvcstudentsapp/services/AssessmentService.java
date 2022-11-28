package com.example.mvcstudentsapp.services;

import com.example.mvcstudentsapp.entities.Assessment;
import com.example.mvcstudentsapp.entities.Student;
import com.example.mvcstudentsapp.entities.Subject;
import com.example.mvcstudentsapp.repositories.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public List<Assessment> findAllAssessmentByStudentId(long studentId){
        return assessmentRepository.findAllAssessmentByStudentId(studentId);
    }

    public List<String> findAvgAssessmentsByStudentId(long studentId){
        return assessmentRepository.findAvgAssessmentsByStudentId(studentId);
    }

    public Double findAvgScoreSubjectByStudentId(long studentId) {
        return assessmentRepository.findAvgScoreSubjectByStudentId(studentId);
    }

    public void deleteById(Long id) {
        // 1. найти студента для удаления
        Optional<Assessment> deleted = assessmentRepository.findById(id);
        // 2. если такой студент есть, то удалить его
        deleted.ifPresent(assessment -> assessmentRepository.delete(assessment));
    }

//    public List<Assessment> findAllStudentGrades(long studentId){
//        List<Assessment> ass = (List<Assessment>) assessmentRepository.findAll();
//        List<Assessment> result = new ArrayList<>();
//        for (Assessment a: ass
//             ) {
//            if(a.getStudent().getId() == studentId){
//                result.add(a);
//            }
//        }
//
//        return result;
//
//    }
}
