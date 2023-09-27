package com.example.springbootstudentmanagement.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;
    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
    private List<Sections> sections;

    public Classroom() {
    }

    public Classroom(Long id, String roomNumber, List<Sections> sections) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.sections = sections;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Sections> getSections() {
        return sections;
    }

    public void setSections(List<Sections> sections) {
        this.sections = sections;
    }
}
