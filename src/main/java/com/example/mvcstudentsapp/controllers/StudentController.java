package com.example.mvcstudentsapp.controllers;

import com.example.mvcstudentsapp.controllers.filter.StudentNameFilter;
import com.example.mvcstudentsapp.entities.Student;
import com.example.mvcstudentsapp.services.AssessmentService;
import com.example.mvcstudentsapp.services.GroupService;
import com.example.mvcstudentsapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("students-templates/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private StudentNameFilter containsFilter;   // объект фильтра

//    @GetMapping()
//    public String showAll(Model model) {
//        List<Student> listStudents = studentService.getAll();
//        model.addAttribute("listStudents", listStudents);
//        model.addAttribute("containsFilter", containsFilter);
//        return "students";
//    }

    @GetMapping()
    public String showAll(Model model, @RequestParam(value = "match", required = false) String match) {
        List<Student> listStudents = studentService.getAllWithFilter(match);
        model.addAttribute("listStudents", listStudents);
        model.addAttribute("match", match);
        return "students-templates/students";
    }

    @PostMapping()
    public String showFilteredStudents(StudentNameFilter filter, Model model) {
        List<Student> studentList = filter.getFilteredStudents(studentService);
        model.addAttribute("studentsList", studentList);
        model.addAttribute("containsFilter", filter);
        return "students-templates/students";
    }


    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("groupsList", groupService.listAllGroups());
        return "students-templates/student-form";
    }

    @GetMapping("/details/{id}")
    public String showDetails(Model modal, @PathVariable(value = "id") Long id) {
        Student student = studentService.getById(id).get();
        modal.addAttribute(student);
        modal.addAttribute("assessmentList", assessmentService.findAllAssessmentByStudentId(id));
        modal.addAttribute("avgValue", assessmentService.findAvgScoreSubjectByStudentId(id));
        modal.addAttribute("allAssessmentsAVG", assessmentService.findAvgAssessmentsByStudentId(id));

        return "students-templates/student-details";
    }

    @GetMapping("/editForm/{id}")
    public String editForm(Model modal, @PathVariable(value = "id", required = false) Long id) {
        Student student = studentService.getById(id).get();
        modal.addAttribute("student", student);
        modal.addAttribute("groupsList", groupService.listAllGroups());
        return "students-templates/student-form";
    }

    @PostMapping("/editForm")
    public String addOrEditForm(Student student, RedirectAttributes ra) {
        Student std = studentService.save(student);
        // 2. добавить сообщение о том, что студент добавлен
        ra.addFlashAttribute("message",
                "Student " + std + " saved successfully");
        // 3. выполнить перенаправление
        return "redirect:/students-templates/students";
    }

//    @GetMapping("/remove/{id}")
//    public String removeById(@PathVariable(value = "id") Long id){
//        service.deleteById(id);
//        return "redirect:/students";
//    }

    @GetMapping("/remove/{id}")
    public String removeById(@PathVariable(value = "id") Long id, RedirectAttributes ra) {
        studentService.deleteById(id);
        ra.addFlashAttribute("message", "Student delete");
        return "redirect:/students-templates/students";
    }

}
