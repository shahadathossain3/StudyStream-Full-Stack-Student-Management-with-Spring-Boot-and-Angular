package com.example.springbootstudentmanagement.dto;

import java.time.LocalTime;
import java.util.Date;

public class ExaminationDTO {
    private Long id;
    private String name;
    private String type;
    private Date date;
    private LocalTime time;
    private SubjectsDTO subjects;

    private ClassroomDTO classroom;

    public ExaminationDTO() {
    }

    public ExaminationDTO(Long id, String name, String type, Date date, LocalTime time, SubjectsDTO subjects, ClassroomDTO classroom) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date = date;
        this.time = time;
        this.subjects = subjects;
        this.classroom = classroom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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
