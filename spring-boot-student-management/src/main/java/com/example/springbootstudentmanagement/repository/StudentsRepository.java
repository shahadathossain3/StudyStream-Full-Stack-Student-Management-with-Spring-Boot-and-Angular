package com.example.springbootstudentmanagement.repository;


import com.example.springbootstudentmanagement.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
    Students findByStudentID(String id);
}
