package com.example.mvcstudentsapp.controllers;

import com.example.mvcstudentsapp.entities.Subject;
import com.example.mvcstudentsapp.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;


    @GetMapping()
    public String showAll(Model model) {
        List<Subject> listSubjects = subjectService.getAll();
        model.addAttribute("listSubjects", listSubjects);
        return "subjects";
    }
}
