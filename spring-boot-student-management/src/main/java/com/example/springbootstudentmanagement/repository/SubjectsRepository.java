package com.example.springbootstudentmanagement.repository;

import com.example.springbootstudentmanagement.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Long> {
}
