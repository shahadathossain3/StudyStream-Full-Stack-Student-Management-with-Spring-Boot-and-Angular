package com.example.springbootstudentmanagement.controller;

import com.example.springbootstudentmanagement.dto.SubjectsDTO;
import com.example.springbootstudentmanagement.model.Result;
import com.example.springbootstudentmanagement.model.Sections;
import com.example.springbootstudentmanagement.model.Subjects;
import com.example.springbootstudentmanagement.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subjects/")
public class SubjectsController {
    @Autowired
    private SubjectsService subjectsService;

    @GetMapping("getAllSubjectList")
    ResponseEntity<?> getAllSubjectsList()
    {
        return ResponseEntity.ok().body(subjectsService.getAllSubjects());
    }

    @PostMapping("addSubjects")
    ResponseEntity<?> addSubjects(@RequestBody SubjectsDTO subjectsDTO)
    {
        return ResponseEntity.ok().body(subjectsService.saveSubjects(subjectsConvertFromDTO(subjectsDTO)));
    }


    public Subjects subjectsConvertFromDTO(SubjectsDTO subjectsDTO)
    {
        Subjects subjects=new Subjects();
        subjects.setId(subjects.getId());
        subjects.setCode(subjectsDTO.getCode());
        subjects.setName(subjectsDTO.getName());
        return subjects;
    }
}
