package com.example.navigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigator.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
