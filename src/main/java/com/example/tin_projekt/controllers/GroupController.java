package com.example.tin_projekt.controllers;

import com.example.tin_projekt.database.dao.GroupRepository;
import com.example.tin_projekt.database.dao.StudentRepository;
import com.example.tin_projekt.database.entity.GroupEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/showList")
    public String showList(Model model){
        model.addAttribute(
                "groups", groupRepository.findAll());

        return "pages/group/list";
    }

    @GetMapping("/form")
    public String showSignUpForm(Model model) {
        model.addAttribute("group", new GroupEntity());
        return "pages/group/form";
    }

    @PostMapping("/add")
    public String addGroup(@Valid GroupEntity group, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("\nJakiś błąd /update/{id}");
            System.out.println(result.getAllErrors());
            return "pages/group/form";
        }

        groupRepository.save(group);

        model.addAttribute("groups", groupRepository.findAll());

        return "redirect:/group/showList";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        GroupEntity group = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid group Id:" + id));

        model.addAttribute("group", group);

        return "pages/group/form-edit";
    }

    @PostMapping("/update/{id}")
    public String updateGroup(@PathVariable("id") long id, @Valid GroupEntity group,
                                BindingResult result, Model model) {

        if (result.hasErrors()) {
            System.out.println("\nJakiś błąd /update/{id}");
            System.out.println(result.getAllErrors());
            group.setId(id);
            return "pages/group/update";
        }

        groupRepository.save(group);

        model.addAttribute("groups", groupRepository.findAll());

        return "redirect:/group/showList";
    }

    @GetMapping("/delete/{id}")
    public String deleteGroup(@PathVariable("id") long id, Model model) {
        GroupEntity group = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid group Id:" + id));
        groupRepository.delete(group);
        return "redirect:/group/showList";
    }

    @GetMapping("/details/{id}")
    public String showStudentDetails(@PathVariable("id") long id, Model model) {
        GroupEntity group = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid group Id:" + id));

        model.addAttribute("group", group);
        model.addAttribute("students", studentRepository.findAllStudentsBelongToGroup(group));

        return "pages/group/details";
    }
}
