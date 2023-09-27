package com.example.springbootstudentmanagement.controller;


import com.example.springbootstudentmanagement.dto.EnrollmentDTO;
import com.example.springbootstudentmanagement.model.Enrollment;
import com.example.springbootstudentmanagement.model.Sections;
import com.example.springbootstudentmanagement.model.Students;
import com.example.springbootstudentmanagement.model.Teachers;
import com.example.springbootstudentmanagement.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enrollment/")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("addEnrollment")
    public Enrollment addEnrollment(@RequestBody EnrollmentDTO enrollmentDTO)
    {

        return enrollmentService.saveEnrollment(enrollmentConvertFromDTO(enrollmentDTO));
    }



    public Enrollment enrollmentConvertFromDTO(EnrollmentDTO enrollmentDTO)
    {
        Enrollment enrollment=new Enrollment();
        if(enrollmentDTO.getStudents().getId()!=null) {
            Students students = new Students();
            students.setId(enrollmentDTO.getStudents().getId());
            enrollment.setStudents(students);
            enrollment.setTeachers(null);
        }
        if (enrollmentDTO.getTeachers().getId()!=null) {
            Teachers teachers = new Teachers();
            teachers.setId(enrollmentDTO.getTeachers().getId());
            enrollment.setTeachers(teachers);
            enrollment.setStudents(null);
        }

        Sections sections=new Sections();
        sections.setId(enrollmentDTO.getSections().getId());
        enrollment.setSections(sections);
        return enrollment;

    }
}
