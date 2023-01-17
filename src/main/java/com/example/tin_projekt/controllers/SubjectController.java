package com.example.tin_projekt.controllers;

import com.example.tin_projekt.database.dao.SubjectRepository;
import com.example.tin_projekt.database.entity.StudentEntity;
import com.example.tin_projekt.database.entity.SubjectEntity;
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
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/showList")
    public String showList(Model model){
        model.addAttribute(
                "subjects", subjectRepository.findAll());

        return "pages/subject/list";
    }

    @GetMapping("/form")
    public String showSignUpForm(Model model) {
        model.addAttribute("subject", new SubjectEntity());

        return "pages/subject/form";
    }

    @PostMapping("/add")
    public String addSubject(@Valid SubjectEntity subject, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("\nJakiś błąd /update/{id}");
            System.out.println(result.getAllErrors());
            return "pages/subject/form";
        }

        subjectRepository.save(subject);

        model.addAttribute("subjects", subjectRepository.findAll());

        return "redirect:/subject/showList";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        SubjectEntity subject = subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject Id:" + id));

        model.addAttribute("subject", subject);

        return "pages/subject/form-edit";
    }

    @PostMapping("/update/{id}")
    public String updateSubject(@PathVariable("id") long id, @Valid SubjectEntity subject,
                                BindingResult result, Model model) {

        if (result.hasErrors()) {
            System.out.println("\nJakiś błąd /update/{id}");
            System.out.println(result.getAllErrors());
            subject.setId(id);
            return "pages/subject/update";
        }

        subjectRepository.save(subject);

        model.addAttribute("subjects", subjectRepository.findAll());

        return "redirect:/subject/showList";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubject(@PathVariable("id") long id, Model model) {
        SubjectEntity subject = subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject Id:" + id));

        subjectRepository.delete(subject);

        return "redirect:/subject/showList";
    }

    @GetMapping("/details/{id}")
    public String showSubjectDetails(@PathVariable("id") long id, Model model) {
        SubjectEntity subject = subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject Id:" + id));

        model.addAttribute("subject", subject);

        return "pages/subject/details";
    }
}
