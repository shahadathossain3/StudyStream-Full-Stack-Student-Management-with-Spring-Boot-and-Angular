package com.example.springbootstudentmanagement.controller;

import com.example.springbootstudentmanagement.dto.ResultDTO;
import com.example.springbootstudentmanagement.model.*;
import com.example.springbootstudentmanagement.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("result/")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping("studentListWithSubject/{id}")
    public ResponseEntity<?> getStudentListWithSubject(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(resultService.getSubjectWithSection(id));
    }

    @PostMapping("addResult")
    public ResponseEntity<?> addResult(@RequestBody List<ResultDTO> resultDTOS)
    {
        List<Result> results=new ArrayList<>();
        for(ResultDTO resultDTO: resultDTOS)
        {

            Result result=new Result();
            result.setId(resultDTO.getId());
            result.setComment(resultDTO.getComment());
            result.setMarks(resultDTO.getMarks());
            Examination examination=new Examination();
            examination.setId(resultDTO.getExamination().getId());
            Subjects subjects=new Subjects();
            subjects.setId(resultDTO.getSubjects().getId());
            Students students=new Students();
            students.setId(resultDTO.getStudents().getId());
            Teachers teachers=new Teachers();
            teachers.setId(resultDTO.getTeachers().getId());
            result.setExamination(null);
            result.setSubjects(subjects);
            result.setStudents(students);
            result.setTeachers(null);
            results.add(result);
        }

        return ResponseEntity.ok().body(resultService.saveResult(results));
    }
}
