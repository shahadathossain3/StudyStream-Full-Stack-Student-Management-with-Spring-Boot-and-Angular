package com.example.springbootstudentmanagement.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class SectionsWithSubjectsClassroomDTO {
    private Long id;
    private DayOfWeek day;
    private LocalTime time;
    private String section;
    private SubjectsDTO subjects;
    private ClassroomDTO classroom;

    public SectionsWithSubjectsClassroomDTO() {
    }

    public SectionsWithSubjectsClassroomDTO(Long id, DayOfWeek day, LocalTime time, String section, SubjectsDTO subjects, ClassroomDTO classroom) {
        this.id = id;
        this.day = day;
        this.time = time;
        this.section = section;
        this.subjects = subjects;
        this.classroom = classroom;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public SubjectsDTO getSubjects() {
        return subjects;
    }

    public void setSubjects(SubjectsDTO subjects) {
        this.subjects = subjects;
    }

    public ClassroomDTO getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomDTO classroom) {
        this.classroom = classroom;
    }
}
