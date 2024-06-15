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


@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Exam registerExam(Long userId, Long subjectId, Exam exam) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException("Subject not found"));

        // Check if the user is enrolled in the subject
        if (!subject.getUser().getId().equals(user.getId())) {
            throw new UserNotEnrolledInSubjectException("User not enrolled in subject");
        }

        // Assign the user and subject to the exam
        exam.setUser(user);
        exam.setSubject(subject);

        return examRepository.save(exam);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam registerUser(Long examId, User user){

                User registerUser = userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException("User not found"));

                Exam getExam= examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException("Exam not found"));
                
                getExam.setUser(registerUser);
                examRepository.save(getExam);

            return getExam;

    }

    
}
