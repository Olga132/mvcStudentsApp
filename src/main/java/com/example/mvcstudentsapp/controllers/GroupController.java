package com.example.mvcstudentsapp.controllers;

import com.example.mvcstudentsapp.entities.Group;
import com.example.mvcstudentsapp.entities.Student;
import com.example.mvcstudentsapp.services.GroupService;
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
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping()
    public String showAll(Model model) {
        List<Group> listGroups = groupService.listAllGroups();
        model.addAttribute("groupsList", listGroups);
        return "groups";
    }

    @GetMapping("/addGroup")
    public String addNew(Model model) {
        model.addAttribute("group", new Group());
        model.addAttribute("groupsList",groupService.listAllGroups());
        return "group-form";
    }

    @GetMapping("/editForm/{id}")
    public String editForm(Model modal, @PathVariable(value = "id", required = false) Long id){
        Group group = groupService.getById(id).get();
        modal.addAttribute("group",group);
        modal.addAttribute("groupsList",groupService.listAllGroups());
        return "group-form";
    }

    @GetMapping("/remove/{id}")
    public String removeById(@PathVariable(value = "id") Long id, RedirectAttributes ra){
        groupService.deleteById(id);
        ra.addFlashAttribute("message", "Group delete");
        return "redirect:/groups";
    }

    @PostMapping("/editForm")
    public String addOrEditForm(Group group, RedirectAttributes ra){
        Group grp = groupService.save(group);
        // 2. добавить сообщение
        ra.addFlashAttribute("message",
                "Group " + grp + " saved successfully");
        // 3. выполнить перенаправление
        return "redirect:/groups";
    }
}
