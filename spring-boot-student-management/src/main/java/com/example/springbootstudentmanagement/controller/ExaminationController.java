package com.example.springbootstudentmanagement.controller;

import com.example.springbootstudentmanagement.dto.ExaminationDTO;
import com.example.springbootstudentmanagement.model.Classroom;
import com.example.springbootstudentmanagement.model.Examination;
import com.example.springbootstudentmanagement.model.Sections;
import com.example.springbootstudentmanagement.model.Subjects;
import com.example.springbootstudentmanagement.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("examination/")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    @GetMapping("examList")
    public ResponseEntity<?> examList()
    {
        return ResponseEntity.ok().body(examinationService.examinationList());
    }


    @PostMapping("addExamination")
    public ResponseEntity<?> addExamination(@RequestBody ExaminationDTO examinationDTO)
    {
        return ResponseEntity.ok().body(examinationService.saveExamination(examinationConvertFromDTO(examinationDTO)));
    }

    public Examination examinationConvertFromDTO(ExaminationDTO examinationDTO)
    {
        Examination examination=new Examination();
        Subjects subjects=new Subjects();
        Classroom classroom=new Classroom();
        classroom.setId(examinationDTO.getClassroom().getId());
        subjects.setId(examinationDTO.getSubjects().getId());
        examination.setId(examinationDTO.getId());
        examination.setName(examinationDTO.getName());
        examination.setType(examinationDTO.getType());
        examination.setDate(examinationDTO.getDate());
        examination.setTime(examinationDTO.getTime());
        examination.setSubjects(subjects);
        examination.setClassroom(classroom);
        return examination;
    }
}
