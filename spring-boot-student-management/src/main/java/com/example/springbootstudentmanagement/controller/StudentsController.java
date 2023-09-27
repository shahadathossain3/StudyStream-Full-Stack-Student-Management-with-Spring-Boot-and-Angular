package com.example.springbootstudentmanagement.controller;


import com.example.springbootstudentmanagement.dto.SectionsDTO;
import com.example.springbootstudentmanagement.dto.StudentsDTO;
import com.example.springbootstudentmanagement.model.Roles;
import com.example.springbootstudentmanagement.model.Students;
import com.example.springbootstudentmanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("students/")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;
    @Autowired
    private SectionsService sectionsService;
    @Autowired
    private ExaminationService examinationService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolesService rolesService;

    @GetMapping("getAllStudentsList")
    public ResponseEntity<?> getStudentsList()
    {
        return ResponseEntity.ok().body(studentsService.getAllStudents());
    }

    @PostMapping("addStudents")
    public ResponseEntity<?> addStudent(@RequestBody StudentsDTO studentsDTO)
    {
        return ResponseEntity.ok().body(studentsService.saveStudent(studentsConvertFromDTO(studentsDTO)));
    }

    @GetMapping("getSectionWithClassroomSubject/{studentID}")
    public ResponseEntity<?> getSectionWithClassroomSubjectList(@PathVariable String studentID)
    {
        return ResponseEntity.ok().body(sectionsService.getByStudentIDorTeacherID("student",studentID));
    }

    @GetMapping("getExamination/{studentID}")
    public ResponseEntity<?> getExamination(@PathVariable String studentID)
    {
        return ResponseEntity.ok().body(examinationService.getExaminationRoutine(studentID));
    }

    @GetMapping("getStudentById/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(studentsService.StudentById(id));
    }

    public Students studentsConvertFromDTO(StudentsDTO studentsDTO)
    {
        List<Roles> rolesList=rolesService.getRoleByName("ROLE_STUDENT");
        Students students=new Students();
        students.setId(studentsDTO.getId());
        students.setFirstName(studentsDTO.getFirstName());
        students.setLastName(studentsDTO.getLastName());
        students.setFatherName(studentsDTO.getFatherName());
        students.setMotherName(studentsDTO.getMotherName());
        students.setStudentID(studentsDTO.getStudentID());
        students.setPassword(passwordEncoder.encode(studentsDTO.getPassword()));
        students.setDateOfBirth(studentsDTO.getDateOfBirth());
        students.setGender(studentsDTO.getGender());
        students.setAddress(studentsDTO.getAddress());
        students.setPhone(studentsDTO.getPhone());
        students.setDateOfJoin(studentsDTO.getDateOfJoin());
        students.setUsername(studentsDTO.getStudentID());
        students.setRoles(rolesList);
        return students;
    }

    @GetMapping("resultwithSubjects/{id}")
    public ResponseEntity<?> getStudentResultWithSubject(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(resultService.getStudentResult(id));
    }
}

