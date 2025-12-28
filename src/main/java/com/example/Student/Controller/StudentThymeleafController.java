package com.example.Student.Controller;

import com.example.Student.Model.Student;
import com.example.Student.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentThymeleafController {

    @Autowired
    private StudentServices studentServices;

    // READ – Display all students
    @GetMapping
    public String viewStudents(Model model) {
        model.addAttribute("students", studentServices.getAll());
        model.addAttribute("student", new Student()); // for form binding
        return "students";
    }

    // CREATE – Save student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentServices.saveEntry(student);
        return "redirect:/students";
    }

    // UPDATE – Load edit form
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = studentServices.getByID(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        model.addAttribute("student", student);
        model.addAttribute("students", studentServices.getAll());
        return "students";
    }

    // DELETE – Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentServices.deleteID(id);
        return "redirect:/students";
    }
}
