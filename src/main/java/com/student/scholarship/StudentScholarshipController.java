package com.student.scholarship;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@RestController
public class StudentScholarshipController {

    @Autowired
    private StudentScholarshipRepository studentRepository;

    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody StudentScholarship studentScholarship) {
        studentRepository.save(studentScholarship);
        return "Student added successfully::"+studentScholarship.getId();

    }
}
