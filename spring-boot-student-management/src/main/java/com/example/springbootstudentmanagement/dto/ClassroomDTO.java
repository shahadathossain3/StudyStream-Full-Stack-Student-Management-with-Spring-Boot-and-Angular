package com.example.springbootstudentmanagement.dto;

public class ClassroomDTO {
    private Long id;
    private String roomNumber;

    public ClassroomDTO() {
    }

    public ClassroomDTO(Long id, String roomNumber) {
        this.id = id;
        this.roomNumber = roomNumber;
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
}
