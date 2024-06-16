package com.example.navigator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.navigator.entities.Exam;
import com.example.navigator.entities.Subject;
import com.example.navigator.entities.User;
import com.example.navigator.service.ExamService;
import com.example.navigator.service.SubjectService;
import com.example.navigator.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SubjectService subjectService;

     @Autowired
    private ExamService examService;

   @PostMapping
    public User addStudent(@RequestBody User student) {
        return userService.saveUser(student);
    }

    @PostMapping("/{studentId}/subjects/{subjectId}")
    public User enrollSubject(@PathVariable Long studentId, @PathVariable Long subjectId) {
        return userService.enrollSubject(studentId, subjectId);
    }

    @PostMapping("/{studentId}/exams/{examId}")
    public Exam registerExam(@PathVariable Long studentId, @PathVariable Long examId) {
        return userService.registerExam(studentId, examId);
    }

    @GetMapping
    public List<User> getAllStudents() {
        return userService.getAllUsers();
    }

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/exams")
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @DeleteMapping("/subjects/{subjectId}")
    public void deleteSubject(@PathVariable Long subjectId) {
        userService.deleteSubject(subjectId);
    }





    
}
