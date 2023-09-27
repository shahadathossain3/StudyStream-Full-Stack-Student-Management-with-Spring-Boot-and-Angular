package com.example.springbootstudentmanagement.controller;


import com.example.springbootstudentmanagement.dto.TeachersDTO;
import com.example.springbootstudentmanagement.model.Roles;
import com.example.springbootstudentmanagement.model.Teachers;
import com.example.springbootstudentmanagement.service.RolesService;
import com.example.springbootstudentmanagement.service.SectionsService;
import com.example.springbootstudentmanagement.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("teachers/")
public class TeachersController {

    @Autowired
    private TeachersService teachersService;
    @Autowired
    private SectionsService sectionsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolesService rolesService;

    @GetMapping("getTeachersList")
    public ResponseEntity<?> getTeachersList()
    {
        return ResponseEntity.ok().body(teachersService.getAllTeachers());
    }

    @PostMapping("addTeachers")
    public ResponseEntity<?> addTeachers(@RequestBody TeachersDTO teachersDTO)
    {
        return ResponseEntity.ok().body(teachersService.saveTeachers(teachersConvertFromDTO(teachersDTO)));
    }

    @GetMapping("getSectionWithClassroomSubject/{id}")
    public ResponseEntity<?> getSectionWithClassroomSubjectList(@PathVariable String id)
    {
        return ResponseEntity.ok().body(sectionsService.getByStudentIDorTeacherID("teacher",id));
    }

    public Teachers teachersConvertFromDTO(TeachersDTO teachersDTO)
    {
        List<Roles> roles=rolesService.getRoleByName("ROLE_TEACHER");
        Teachers teachers=new Teachers();
        teachers.setId(teachersDTO.getId());
        teachers.setFirstName(teachersDTO.getFirstName());
        teachers.setLastName(teachersDTO.getLastName());
        teachers.setTeacherID(teachersDTO.getTeacherID());
        teachers.setPassword(passwordEncoder.encode(teachersDTO.getPassword()));
        teachers.setGender(teachersDTO.getGender());
        teachers.setAddress(teachersDTO.getAddress());
        teachers.setMobile(teachersDTO.getMobile());
        teachers.setDateOfJoin(teachersDTO.getDateOfJoin());
        teachers.setUsername(teachersDTO.getTeacherID());
        teachers.setRoles(roles);
        return teachers;
    }
}
