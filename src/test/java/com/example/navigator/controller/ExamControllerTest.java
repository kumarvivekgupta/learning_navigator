package com.example.navigator.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.navigator.entities.Exam;
import com.example.navigator.entities.Subject;
import com.example.navigator.service.ExamService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ExamController.class)
public class ExamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExamService examService;

    @Autowired
    private ObjectMapper objectMapper;

    private Exam exam;
    private Subject subject;

    @BeforeEach
    void setUp() {
        subject = new Subject(1L, "Math", null, null);
        exam = new Exam(1L, "Midterm", subject, null);
    }

    @Test
    void testAddExam() throws Exception {
        when(examService.addExam(any(Exam.class))).thenReturn(exam);

        mockMvc.perform(post("/exams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(exam)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.examId").value(exam.getId()))
                .andExpect(jsonPath("$.name").value(exam.getName()));

        verify(examService, times(1)).addExam(any(Exam.class));
    }

    @Test
    void testGetExam() throws Exception {
        when(examService.getExam(1L)).thenReturn(exam);

        mockMvc.perform(get("/exams/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.examId").value(exam.getId()))
                .andExpect(jsonPath("$.name").value(exam.getName()));

        verify(examService, times(1)).getExam(1L);
    }

    @Test
    void testGetAllExams() throws Exception {
        List<Exam> exams = Collections.singletonList(exam);
        when(examService.getAllExams()).thenReturn(exams);

        mockMvc.perform(get("/exams")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].examId").value(exam.getId()))
                .andExpect(jsonPath("$[0].name").value(exam.getName()));

        verify(examService, times(1)).getAllExams();
    }
}

