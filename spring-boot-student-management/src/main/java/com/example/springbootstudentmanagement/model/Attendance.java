package com.example.springbootstudentmanagement.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Boolean present;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "students_id")
    private Students students;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teachers_id")
    private Teachers teachers;

    public Attendance() {
    }

    public Attendance(Long id, Date date, Boolean present, Students students, Teachers teachers) {
        this.id = id;
        this.date = date;
        this.present = present;
        this.students = students;
        this.teachers = teachers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
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
}
