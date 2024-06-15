package com.example.navigator.entities;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exams")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
