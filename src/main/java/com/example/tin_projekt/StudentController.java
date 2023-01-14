package com.example.tin_projekt;

import com.example.tin_projekt.database.dao.GroupRepository;
import com.example.tin_projekt.database.dao.StudentRepository;
import com.example.tin_projekt.database.entity.StudentEntity;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("/showList")
    public String showList(Model model){
        model.addAttribute(
                "students", studentRepository.findAll());

        return "pages/student/list";
    }

    @GetMapping("/form")
    public String showSignUpForm(Model model) {
        model.addAttribute("student", new StudentEntity());
        model.addAttribute("groups", groupRepository.findAll());
        return "pages/student/form";
    }

    @PostMapping("/add")
    public String addStudent(@Valid StudentEntity student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("\nJakiś błąd /update/{id}");
            System.out.println(result.getAllErrors());
            return "pages/student/form";
        }

        studentRepository.save(student);

        model.addAttribute("students", studentRepository.findAll());

        return "redirect:/student/showList";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));

        model.addAttribute("student", student);
        model.addAttribute("groups", groupRepository.findAll());

        return "pages/student/form-edit";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid StudentEntity student,
                                BindingResult result, Model model) {

        if (result.hasErrors()) {
            System.out.println("\nJakiś błąd /update/{id}");
            System.out.println(result.getAllErrors());
            student.setId(id);
            return "pages/student/update";
        }

        studentRepository.save(student);

        model.addAttribute("students", studentRepository.findAll());

        return "redirect:/student/showList";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        studentRepository.delete(student);
        return "redirect:/student/showList";
    }

    @GetMapping("/details/{id}")
    public String showStudentDetails(@PathVariable("id") long id, Model model) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));

        model.addAttribute("student", student);

        return "pages/student/details";
    }
}
