package com.example.navigator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.navigator.entities.Exam;
import com.example.navigator.entities.User;
import com.example.navigator.service.ExamService;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping()
    public Exam registerExam(@RequestParam Long userId, @RequestParam Long subjectId, @RequestBody Exam exam) {
        return examService.registerExam(userId, subjectId, exam);
    }

     @PostMapping("/{examId}")
    public Exam registerUser(@PathVariable("examId") Long examId, @RequestParam User user) {
        return examService.registerUser(examId,user);
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }


}
