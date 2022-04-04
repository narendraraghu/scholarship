package com.student.scholarship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

    @GetMapping("/getAllCount")
    public int getAllCount() {
        try {
            return studentRepository.getTotalStudentByName("abc");
        } catch (Exception ex) {
            return 100;

        }
    }

    @GetMapping("/calculatescholarship")
    public int calculateScholarship() {
        try {
            return studentRepository.calculateScholarship(10000);
        } catch (Exception ex) {
            return 00;

        }
    }
    @GetMapping("/api/v3/call")
    public String  apiCall() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://192.168.5.72:3000/narendra"))
                .GET() // GET is default
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response ** : " +response.statusCode());
        System.out.println("Response Body ** : " +response.body());
        return response.body();
    }
}
