package com.example.springbootstudentmanagement.dto;

public class EnrollmentDTO {
    private Long id;
    private StudentsDTO students;
    private TeachersDTO teachers;
    private SectionsDTO sections;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(Long id, StudentsDTO students, TeachersDTO teachers, SectionsDTO sections) {
        this.id = id;
        this.students = students;
        this.teachers = teachers;
        this.sections = sections;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentsDTO getStudents() {
        return students;
    }

    public void setStudents(StudentsDTO students) {
        this.students = students;
    }

    public TeachersDTO getTeachers() {
        return teachers;
    }

    public void setTeachers(TeachersDTO teachers) {
        this.teachers = teachers;
    }

    public SectionsDTO getSections() {
        return sections;
    }

    public void setSections(SectionsDTO sections) {
        this.sections = sections;
    }
}
