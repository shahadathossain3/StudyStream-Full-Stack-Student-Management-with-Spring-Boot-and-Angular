package com.example.springbootstudentmanagement.service;

import com.example.springbootstudentmanagement.dto.ClassroomDTO;
import com.example.springbootstudentmanagement.dto.ExaminationDTO;
import com.example.springbootstudentmanagement.dto.SubjectsDTO;
import com.example.springbootstudentmanagement.model.*;
import com.example.springbootstudentmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminationService {
    @Autowired
    private ExaminationRepository examinationRepository;
    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private SectionsRepository sectionsRepository;

    public List<ExaminationDTO> getExaminationRoutine(String studentId)
    {
        Students students=studentsRepository.findByStudentID(studentId);
        List<Enrollment> enrollments=enrollmentRepository.findByStudentsId(students.getId());
        List<ExaminationDTO> examinationDTOS=new ArrayList<>();
        for(Enrollment enrollment:enrollments)
        {
            Sections sections=sectionsRepository.findById(enrollment.getSections().getId()).orElse(null);
            Examination examination=examinationRepository.findBySubjectsId(sections.getSubjects().getId());
//            Examination examination=examinationRepository.findBySubjectsId(sections.getSubjects().getId());

            SubjectsDTO subjectsDTO=new SubjectsDTO();
            subjectsDTO.setId(examination.getSubjects().getId());
            subjectsDTO.setName(examination.getSubjects().getName());
            subjectsDTO.setCode(examination.getSubjects().getCode());
            ClassroomDTO classroomDTO=new ClassroomDTO();
            classroomDTO.setId(examination.getClassroom().getId());
            classroomDTO.setRoomNumber(examination.getClassroom().getRoomNumber());
            ExaminationDTO examinationDTO=new ExaminationDTO();
            examinationDTO.setId(examination.getId());
            examinationDTO.setName(examination.getName());
            examinationDTO.setDate(examinationDTO.getDate());
            examinationDTO.setTime(examination.getTime());
            examinationDTO.setClassroom(classroomDTO);
            examinationDTO.setSubjects(subjectsDTO);
            examinationDTOS.add(examinationDTO);
        }
        return examinationDTOS;
    }

    public Examination saveExamination(Examination examination)
    {
        return examinationRepository.save(examination);
    }

    public List<ExaminationDTO> examinationList()
    {
        List<Examination> examinations=examinationRepository.findAll();
        List<ExaminationDTO> examinationDTOS=new ArrayList<>();
        for (Examination examination:examinations)
        {
            ExaminationDTO examinationDTO=new ExaminationDTO();
            examinationDTO.setId(examination.getId());
            examinationDTO.setName(examination.getName());
            examinationDTO.setType(examination.getType());
            examinationDTOS.add(examinationDTO);
        }
        return examinationDTOS;
    }
}
