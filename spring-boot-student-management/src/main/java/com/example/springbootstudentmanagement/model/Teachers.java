package com.example.springbootstudentmanagement.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Teachers extends Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String teacherID;
//    private String password;
    private String gender;
    private String address;
    private String mobile;
    private Date dateOfJoin;

    @OneToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
    private List<Enrollment> enrollments;
    @OneToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
    private List<Attendance> attendances;
    @OneToMany(mappedBy = "teachers",fetch = FetchType.LAZY)
    private List<Result> results;

    public Teachers() {
    }

    public Teachers(Long id, String firstName, String lastName, String teacherID, String password, String gender, String address, String mobile, Date dateOfJoin, List<Enrollment> enrollments, List<Attendance> attendances, List<Result> results) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherID = teacherID;
//        this.password = password;
        this.gender = gender;
        this.address = address;
        this.mobile = mobile;
        this.dateOfJoin = dateOfJoin;
        this.enrollments = enrollments;
        this.attendances = attendances;
        this.results = results;
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

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
