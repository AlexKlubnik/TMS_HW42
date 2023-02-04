package by.klubnikov.hw4243.controller;

import by.klubnikov.hw4243.entity.Student;
import by.klubnikov.hw4243.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("students")

public class StudentController {

    private final StudentService service;

    @GetMapping
    public String findAll(Model model) {
        List<Student> studentsList = service.findAll();
        model.addAttribute("studentsList", studentsList);
        return "students";
    }

    @GetMapping("delete")
    public String delete(
            @RequestParam(value = "id") Integer id) {
        System.out.println("this is id: " + id);
        service.delete(id);
        return "redirect:/students";
    }

    @GetMapping("{id}")
    public String findById(Model model, @PathVariable(value = "id") Integer id) {
        Student student = service.findById(id).orElseThrow();
        model.addAttribute("studentFromDB", student);
        return "student";
    }

    @GetMapping("studentform")
    public String showForm(Student student, Model model) {
        model.addAttribute("student", student);
        return "student_form";
    }

    @PostMapping("studentform")
    public String save(Model model, @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            return "student_form";
        }
        service.save(student);
        return "redirect:/students";
    }

}
