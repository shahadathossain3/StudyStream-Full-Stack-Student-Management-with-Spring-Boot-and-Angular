package com.example.springbootstudentmanagement.dto;

import java.util.Date;

public class TeachersDTO extends UsersDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String teacherID;
//    private String password;
    private String gender;
    private String address;
    private String mobile;
    private Date dateOfJoin;

    public TeachersDTO() {
    }

    public TeachersDTO(Long id, String firstName, String lastName, String teacherID, String password, String gender, String address, String mobile, Date dateOfJoin) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherID = teacherID;
//        this.password = password;
        this.gender = gender;
        this.address = address;
        this.mobile = mobile;
        this.dateOfJoin = dateOfJoin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }
}
