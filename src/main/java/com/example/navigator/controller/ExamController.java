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
import com.example.navigator.service.ExamService;

@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping
    public Exam addExam(@RequestBody Exam exam) {
        return examService.addExam(exam);
    }

    

    @GetMapping("/{examId}")
    public Exam getExam(@PathVariable Long examId) {
        return examService.getExam(examId);
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @DeleteMapping("/{examId}")
    public void deleteExam(@PathVariable Long examId) {
        examService.deleteExam(examId);
    }

    // @PostMapping("/{studentId}/register/{examId}")
    // public Exam registerExam(@PathVariable Long studentId, @PathVariable Long examId) {
    //     return examService.registerExam(studentId, examId);
    // }
}