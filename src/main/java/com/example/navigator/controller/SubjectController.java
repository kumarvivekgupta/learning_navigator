package com.example.navigator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.navigator.entities.Subject;
import com.example.navigator.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectService.addSubject(subject);
    }

    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
}
