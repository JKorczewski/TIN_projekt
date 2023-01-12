package com.example.tin_projekt;

import database.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private StudentRepository studentRepository;

    @GetMapping("/showList")
    public String showStudentList(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "list";
    }

}
