package com.example.navigator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.navigator.entities.Exam;
import com.example.navigator.entities.Subject;
import com.example.navigator.entities.User;
import com.example.navigator.exception.ExamNotFoundException;
import com.example.navigator.exception.SubjectNotFoundException;
import com.example.navigator.exception.UserNotFoundException;
import com.example.navigator.repository.ExamRepository;
import com.example.navigator.repository.SubjectRepository;
import com.example.navigator.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamRepository examRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId){

        if(userRepository.existsById(userId)){
            return userRepository.findById(userId).get();

        }else{

            throw new UserNotFoundException("Wrong User Id");

        }

    }

     public User enrollSubject(Long studentId, Long subjectId) {
        User student = userRepository.findById(studentId)
            .orElseThrow(() -> new UserNotFoundException("Invalid user Id"));
        Subject subject = subjectRepository.findById(subjectId)
            .orElseThrow(() -> new SubjectNotFoundException("Subject Id invald"));

        student.getSubjects().add(subject);
        return userRepository.save(student);
    }

     public Exam registerExam(Long studentId, Long examId) {
        User student = userRepository.findById(studentId)
            .orElseThrow(() -> new UserNotFoundException("Invalid student ID"));
        Exam exam = examRepository.findById(examId)
            .orElseThrow(() -> new ExamNotFoundException("Invalid exam ID"));

        if (!student.getSubjects().contains(exam.getSubject())) {
            throw new SubjectNotFoundException("Student not enrolled in the corresponding subject");
        }

        student.getExams().add(exam);
        return examRepository.save(exam);
    }

    public void deleteSubject(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }


}