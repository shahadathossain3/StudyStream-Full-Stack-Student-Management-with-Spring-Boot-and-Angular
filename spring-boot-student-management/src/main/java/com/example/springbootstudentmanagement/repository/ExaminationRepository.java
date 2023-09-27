package com.example.springbootstudentmanagement.repository;

import com.example.springbootstudentmanagement.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {
    Examination findBySubjectsId(Long id);
}
