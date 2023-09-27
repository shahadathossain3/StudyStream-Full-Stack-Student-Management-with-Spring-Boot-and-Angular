package com.example.springbootstudentmanagement.model;


import javax.persistence.*;

@Entity
@Table
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "students_id")
    private Students students;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teachers teachers;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sections_id")
    private Sections sections;

    public Enrollment() {
    }

    public Enrollment(Long id, Students students, Teachers teachers, Sections sections) {
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

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

    public Sections getSections() {
        return sections;
    }

    public void setSections(Sections sections) {
        this.sections = sections;
    }
}
