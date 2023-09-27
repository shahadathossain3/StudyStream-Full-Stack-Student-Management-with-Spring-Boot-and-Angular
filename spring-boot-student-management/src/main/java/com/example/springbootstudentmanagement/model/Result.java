package com.example.springbootstudentmanagement.model;

import javax.persistence.*;

@Entity
@Table
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer marks;
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examination_id")
    private Examination examination;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "students_id")
    private Students students;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subjects_id")
    private Subjects subjects;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teachers_id")
    private Teachers teachers;

    public Result() {
    }

    public Result(Long id, Integer marks, String comment, Examination examination, Students students, Subjects subjects, Teachers teachers) {
        this.id = id;
        this.marks = marks;
        this.comment = comment;
        this.examination = examination;
        this.students = students;
        this.subjects = subjects;
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

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

}
