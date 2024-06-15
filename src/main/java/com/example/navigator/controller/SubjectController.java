package com.example.navigator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.navigator.entities.User;
import com.example.navigator.entities.Subject;
import com.example.navigator.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public Subject createSubject(@RequestBody Subject sub) {
        return subjectService.saveSubject(sub);
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    // @GetMapping("/{id}")
    // public User getUser(@PathVariable("id") Long userId){
        
    //     return subjectService.getSubjectByID(userId);
        
    // }


    
}

