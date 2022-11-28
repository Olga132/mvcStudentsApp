package com.example.mvcstudentsapp.controllers;

import com.example.mvcstudentsapp.entities.Assessment;
import com.example.mvcstudentsapp.services.AssessmentService;
import com.example.mvcstudentsapp.services.StudentService;
import com.example.mvcstudentsapp.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("assessments-templates/assessments")
public class AssessmentController{

    @Autowired
    AssessmentService assessmentService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    StudentService studentService;


    @GetMapping()
    public String showAll(Model model) {
        List<Assessment> listAssessments = assessmentService.listAllAssessment();
        model.addAttribute("listAssessments", listAssessments);
        return "assessments-templates/assessments";
    }

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("assessment", new Assessment());
        model.addAttribute("assessmentList",assessmentService.listAllAssessment());
        model.addAttribute("subjectList",subjectService.getAll());
        model.addAttribute("studentList",studentService.getAll());
        return "assessments-templates/assessment-form";
    }

    @GetMapping("/remove/{id}")
    public String removeById(@PathVariable(value = "id") Long id, RedirectAttributes ra) {
        assessmentService.deleteById(id);
        ra.addFlashAttribute("message", "Assessment delete");
        return "redirect:/assessments-templates/assessments";
    }

    @PostMapping("/editForm")
    public String addOrEditForm(Assessment assessment, RedirectAttributes ra) {
        Assessment assess = assessmentService.save(assessment);
        // 2. добавить сообщение о том, что студент добавлен
        ra.addFlashAttribute("message",
                "Assessment " + assess + " saved successfully");
        // 3. выполнить перенаправление
        return "redirect:/assessments-templates/assessments";

    }


}
