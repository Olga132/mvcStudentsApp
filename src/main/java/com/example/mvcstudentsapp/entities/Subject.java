package com.example.mvcstudentsapp.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="subject_t")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 50)
    private String subjectName;

//    @OneToMany(mappedBy = "subject")
//    private Set<Assessment> assessments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

//    public Set<Assessment> getAssessments() {
//        return assessments;
//    }
//
//    public void setAssessments(Set<Assessment> assessments) {
//        this.assessments = assessments;
//    }

    @Override
    public String toString() {
        return subjectName;
    }
}
