package com.example.springbootstudentmanagement.service;


import com.example.springbootstudentmanagement.dto.*;
import com.example.springbootstudentmanagement.model.Classroom;
import com.example.springbootstudentmanagement.model.Enrollment;
import com.example.springbootstudentmanagement.model.Subjects;
import com.example.springbootstudentmanagement.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment saveEnrollment(Enrollment enrollment)
    {
        return enrollmentRepository.save(enrollment);
    }
}
