package com.student.scholarship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentScholarshipController {

    @Autowired
    private StudentScholarshipRepository studentRepository;

    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody StudentScholarship studentScholarship) {
        studentRepository.save(studentScholarship);
        return "Student added successfully::" + studentScholarship.getId();

    }

    @GetMapping("/checkStatus/{id}")
    public Boolean saveStudent(@PathVariable Long id) {
        try {
            StudentScholarship studentStatus = studentRepository.getById(id);
            return studentStatus.getStatus();
        } catch (Exception ex) {
            return false;

        }

    }
}
