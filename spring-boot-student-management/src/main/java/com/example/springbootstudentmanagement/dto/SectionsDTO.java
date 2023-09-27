package com.example.springbootstudentmanagement.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class SectionsDTO {
    private Long id;
    private DayOfWeek day;
    private LocalTime time;
    private String name;
    private ClassroomDTO classroom;
    private SubjectsDTO subjects;

    public SectionsDTO() {
    }

    public SectionsDTO(Long id, DayOfWeek day, LocalTime time, String name, ClassroomDTO classroom, SubjectsDTO subjects) {
        this.id = id;
        this.day = day;
        this.time = time;
        this.name = name;
        this.classroom = classroom;
        this.subjects = subjects;
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

    public void setName(String name) {
        this.name = name;
    }

    public ClassroomDTO getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomDTO classroom) {
        this.classroom = classroom;
    }

    public SubjectsDTO getSubjects() {
        return subjects;
    }

    public void setSubjects(SubjectsDTO subjects) {
        this.subjects = subjects;
    }
}
