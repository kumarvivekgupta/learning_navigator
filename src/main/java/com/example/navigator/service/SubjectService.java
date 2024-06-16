package com.example.navigator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.navigator.entities.Subject;
import com.example.navigator.entities.User;
import com.example.navigator.exception.UserNotFoundException;
import com.example.navigator.repository.SubjectRepository;
import com.example.navigator.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;


      public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    

   

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public void deleteSubject(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }

    // Add more methods as needed
}