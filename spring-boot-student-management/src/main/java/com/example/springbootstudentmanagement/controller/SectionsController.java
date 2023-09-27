package com.example.springbootstudentmanagement.controller;


import com.example.springbootstudentmanagement.dto.SectionsDTO;
import com.example.springbootstudentmanagement.model.Classroom;
import com.example.springbootstudentmanagement.model.Sections;
import com.example.springbootstudentmanagement.model.Subjects;
import com.example.springbootstudentmanagement.service.SectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;

@RestController
@RequestMapping("sections/")
public class SectionsController {
    @Autowired
    private SectionsService sectionsService;

    @GetMapping("getAllSectionsList")
    ResponseEntity<?> getAllSectionsList()
    {
        return ResponseEntity.ok().body(sectionsService.getAllSections());
    }


    @PostMapping("addSection")
    ResponseEntity<?> addSections(@RequestBody SectionsDTO sectionsDTO)
    {
        return ResponseEntity.ok().body(sectionsService.saveSections(sectionsConvertFromDTO(sectionsDTO)));
    }

    @GetMapping("dayOfWeek")
    public DayOfWeek[] dayOfWeek()
    {
        return DayOfWeek.values();
    }


    public Sections sectionsConvertFromDTO(SectionsDTO sectionsDTO)
    {
        Classroom classroom=new Classroom();
        classroom.setId(sectionsDTO.getClassroom().getId());

        Subjects subjects=new Subjects();
        subjects.setId(sectionsDTO.getSubjects().getId());

        Sections sections=new Sections();
        sections.setId(sectionsDTO.getId());
        sections.setDay(sectionsDTO.getDay());
        sections.setTime(sectionsDTO.getTime());
        sections.setName(sectionsDTO.getName());
        sections.setClassroom(classroom);
        sections.setSubjects(subjects);
        return sections;
    }
}
