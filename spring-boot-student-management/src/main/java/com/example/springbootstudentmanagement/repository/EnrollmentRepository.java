package com.example.springbootstudentmanagement.repository;

import com.example.springbootstudentmanagement.model.Enrollment;
import com.example.springbootstudentmanagement.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentsId(Long id);
    List<Enrollment> findByTeachersId(Long id);
}
