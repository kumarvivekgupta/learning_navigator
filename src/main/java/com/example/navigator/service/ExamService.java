package com.example.navigator.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.navigator.entities.Exam;
import com.example.navigator.entities.Subject;
import com.example.navigator.entities.User;
import com.example.navigator.exception.ExamNotFoundException;
import com.example.navigator.exception.SubjectNotFoundException;
import com.example.navigator.exception.UserNotEnrolledInSubjectException;
import com.example.navigator.exception.UserNotFoundException;
import com.example.navigator.repository.ExamRepository;
import com.example.navigator.repository.SubjectRepository;
import com.example.navigator.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    
    @Transactional
    public Exam addExam(Exam exam) {
        return examRepository.save(exam);
    }

   

    public Exam getExam(Long examId) {
        return examRepository.findById(examId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid exam ID"));
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public void deleteExam(Long examId) {
        examRepository.deleteById(examId);
    }

   
}

