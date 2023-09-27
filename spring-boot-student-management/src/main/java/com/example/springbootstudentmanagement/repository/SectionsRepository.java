package com.example.springbootstudentmanagement.repository;

import com.example.springbootstudentmanagement.model.Sections;
import com.example.springbootstudentmanagement.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SectionsRepository extends JpaRepository<Sections, Long> {
//    @Query("SELECT student FROM Students student JOIN Enrollment enroll ON student.id=enroll.students.id JOIN Sections section ON section.id=enroll.sections.id where section.subjects.id=:id")
    @Query("SELECT student FROM Students student, Enrollment enroll, Sections section where student.id=enroll.students.id and enroll.sections.id=section.id and section.subjects.id=:id")
    Set<Students> findBySubjectsId(Long id);
}
