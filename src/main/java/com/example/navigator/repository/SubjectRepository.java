package com.example.navigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.navigator.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
