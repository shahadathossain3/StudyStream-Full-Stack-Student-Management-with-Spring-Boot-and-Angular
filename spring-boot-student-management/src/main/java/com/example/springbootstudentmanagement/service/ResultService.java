package com.example.springbootstudentmanagement.service;

import com.example.springbootstudentmanagement.dto.ExaminationDTO;
import com.example.springbootstudentmanagement.dto.ResultDTO;
import com.example.springbootstudentmanagement.dto.StudentsDTO;
import com.example.springbootstudentmanagement.dto.SubjectsDTO;
import com.example.springbootstudentmanagement.model.Examination;
import com.example.springbootstudentmanagement.model.Result;
import com.example.springbootstudentmanagement.model.Sections;
import com.example.springbootstudentmanagement.model.Students;
import com.example.springbootstudentmanagement.repository.ResultRepository;
import com.example.springbootstudentmanagement.repository.SectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private SectionsRepository sectionsRepository;
    @Autowired
    private StudentsService studentsService;

    public List<StudentsDTO> getSubjectWithSection(Long id)
    {
        Set<Students> students = sectionsRepository.findBySubjectsId(id);
        List<StudentsDTO> studentsDTOS=new ArrayList<>();
        for(Students student:students)
        {
            studentsDTOS.add(studentsService.studentConvertToDTO(student));
        }
        return studentsDTOS;
    }

    @Transactional
    public List<Result> saveResult(List<Result> results)
    {
        return resultRepository.saveAll(results);
    }

   public List<ResultDTO> getStudentResult(Long id)
    {
        List<Result> results =  resultRepository.findByStudentsId(id);
        List<ResultDTO> resultDTOS=new ArrayList<>();
        for(Result result:results)
        {
            resultDTOS.add(resultConvertToDTO(result));
        }
        return resultDTOS;
    }

    public ResultDTO resultConvertToDTO(Result result)
    {
        StudentsDTO studentsDTO=new StudentsDTO();
        studentsDTO.setId(result.getId());
        studentsDTO.setFirstName(result.getStudents().getFirstName());
        studentsDTO.setLastName(result.getStudents().getLastName());
        studentsDTO.setStudentID(result.getStudents().getStudentID());
//        ExaminationDTO examinationDTO=new ExaminationDTO();
//        examinationDTO.setId(result.getExamination().getId());
//        examinationDTO.setType(result.getExamination().getType());
//        examinationDTO.setName(result.getExamination().getName());
        SubjectsDTO subjectsDTO=new SubjectsDTO();
        subjectsDTO.setId(result.getSubjects().getId());
        subjectsDTO.setName(result.getSubjects().getName());
        subjectsDTO.setCode(result.getSubjects().getCode());
        ResultDTO resultDTO=new ResultDTO();
        resultDTO.setId(result.getId());
        resultDTO.setMarks(result.getMarks());
        resultDTO.setStudents(studentsDTO);
//        resultDTO.setExamination(examinationDTO);
        resultDTO.setSubjects(subjectsDTO);
        return resultDTO;
    }
}
