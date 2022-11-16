package com.example.mvcstudentsapp.controllers;

import com.example.mvcstudentsapp.entities.Student;
import com.example.mvcstudentsapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;


    @GetMapping()
    public String showAll(Model model) {
        List<Student> listStudents = service.getAll();
        model.addAttribute("listStudents", listStudents);
        return "students";
    }

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @GetMapping("/details/{id}")
    public String showDetails(Model modal, @PathVariable(value = "id") Long id){
        Student student = service.getById(id).get();
        modal.addAttribute(student);
        return "student-details";
    }

    @GetMapping("/editForm/{id}")
    public String editForm(Model modal, @PathVariable(value = "id", required = false) Long id){
        Student student = service.getById(id).get();
        modal.addAttribute("student",student);
        return "student-form";
    }

    @PostMapping("/editForm")
    public String addOrEditForm(Student student, RedirectAttributes ra){
        Student std = service.save(student);
        // 2. добавить сообщение о том, что студент добавлен
        ra.addFlashAttribute("message",
                "Student " + std + " saved successfully");
        // 3. выполнить перенаправление
        return "redirect:/students";
    }

//    @GetMapping("/remove/{id}")
//    public String removeById(@PathVariable(value = "id") Long id){
//        service.deleteById(id);
//        return "redirect:/students";
//    }

    @GetMapping("/remove/{id}")
    public String removeById(@PathVariable(value = "id") Long id, RedirectAttributes ra){
        service.deleteById(id);
        ra.addFlashAttribute("message", "Student delete");
        return "redirect:/students";
    }

}
