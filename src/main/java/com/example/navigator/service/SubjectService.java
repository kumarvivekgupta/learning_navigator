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

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Subject saveSubject(Subject subject) {

                User user = userRepository.findById(subject.getUser().getId()).orElseThrow(() -> new UserNotFoundException("User not found"));

                subject.setUser(user);


        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // Add more methods as needed
}