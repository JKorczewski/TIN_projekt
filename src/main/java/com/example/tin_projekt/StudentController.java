package com.example.tin_projekt;

import com.example.tin_projekt.database.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/showList")
    public String showList(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "pages/student/list";
    }
}
