package com.example.springbootstudentmanagement.model;


import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table
public class Sections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DayOfWeek day;
    private LocalTime time;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subjects_id")
    private Subjects subjects;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @OneToMany(mappedBy = "sections", fetch = FetchType.LAZY)
    private List<Enrollment> enrollments;

    public Sections() {
    }

    public Sections(Long id, DayOfWeek day, LocalTime time, String name, Subjects subjects, Classroom classroom, List<Enrollment> enrollments) {
        this.id = id;
        this.day = day;
        this.time = time;
        this.name = name;
        this.subjects = subjects;
        this.classroom = classroom;
        this.enrollments = enrollments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String section) {
        this.name = section;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
