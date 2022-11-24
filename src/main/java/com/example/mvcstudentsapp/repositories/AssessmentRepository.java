package com.example.mvcstudentsapp.repositories;

import com.example.mvcstudentsapp.entities.Assessment;
import com.example.mvcstudentsapp.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AssessmentRepository extends CrudRepository<Assessment, Long>, JpaRepository<Assessment, Long> {
    // получение всех оценок студента по Id
    @Query("select a from Assessment a where a.student.id=:studentId")
    List<Assessment> findAllAssessmentByStudentId(@Param("studentId") long studentId);

    // получение среднего балла по каждому студенту по Id студента (не работает)
    @Query("select s, avg(a.assessment) from Assessment a join Subject s on a.subject.id = s.id where a.student.id=:studentId group by a.subject.id")
    Map<Subject,Double> findAvgAssessmentsByStudentId(@Param("studentId") long studentId);

    // получения среднего балла студента по всем предметам по Id студента
    @Query("select avg(a.assessment) from Assessment a where a.student.id=:studentId")
    Double findAvgScoreAllAssessmentByStudentId(@Param("studentId") long studentId);


}
