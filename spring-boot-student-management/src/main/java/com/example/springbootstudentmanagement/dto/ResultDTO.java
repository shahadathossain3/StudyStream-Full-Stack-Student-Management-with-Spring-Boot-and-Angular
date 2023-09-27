package com.example.springbootstudentmanagement.dto;

public class ResultDTO {
    private Long id;
    private Integer marks;
    private String comment;
    private ExaminationDTO examination;
    private SubjectsDTO subjects;
    private StudentsDTO students;

    private TeachersDTO teachers;

    public ResultDTO() {
    }

    public ResultDTO(Long id, Integer marks, String comment, ExaminationDTO examination, SubjectsDTO subjects, StudentsDTO students, TeachersDTO teachers) {
        this.id = id;
        this.marks = marks;
        this.comment = comment;
        this.examination = examination;
        this.subjects = subjects;
        this.students = students;
        this.teachers = teachers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ExaminationDTO getExamination() {
        return examination;
    }

    public void setExamination(ExaminationDTO examination) {
        this.examination = examination;
    }

    public SubjectsDTO getSubjects() {
        return subjects;
    }

    public void setSubjects(SubjectsDTO subjects) {
        this.subjects = subjects;
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
}
