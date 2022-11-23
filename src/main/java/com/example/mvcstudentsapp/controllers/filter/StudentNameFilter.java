package com.example.mvcstudentsapp.controllers.filter;

import com.example.mvcstudentsapp.entities.Student;
import com.example.mvcstudentsapp.services.StudentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentNameFilter {

    private String match = "";   // строка фильтра
    public String getMatch() {
        return match;
    }
    public void setMatch(String match) {
        this.match = match;
    }

    public List<Student> getFilteredStudents(StudentService service) {
        // фильтрация студентов на основе включения match в имя или фамилию
        return service.findByContains(match);
    }
}
