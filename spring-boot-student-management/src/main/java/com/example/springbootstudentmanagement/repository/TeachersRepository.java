package com.example.springbootstudentmanagement.repository;

import com.example.springbootstudentmanagement.model.Students;
import com.example.springbootstudentmanagement.model.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers, Long> {
    Teachers findByTeacherID(String id);
}
