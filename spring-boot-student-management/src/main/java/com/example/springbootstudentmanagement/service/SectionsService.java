package com.example.springbootstudentmanagement.service;

import com.example.springbootstudentmanagement.dto.ClassroomDTO;
import com.example.springbootstudentmanagement.dto.SectionsDTO;
import com.example.springbootstudentmanagement.dto.SubjectsDTO;
import com.example.springbootstudentmanagement.model.Enrollment;
import com.example.springbootstudentmanagement.model.Sections;
import com.example.springbootstudentmanagement.model.Students;
import com.example.springbootstudentmanagement.model.Teachers;
import com.example.springbootstudentmanagement.repository.EnrollmentRepository;
import com.example.springbootstudentmanagement.repository.SectionsRepository;
import com.example.springbootstudentmanagement.repository.StudentsRepository;
import com.example.springbootstudentmanagement.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionsService {

    @Autowired
    private SectionsRepository sectionsRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private TeachersRepository teachersRepository;

    public List<SectionsDTO> getAllSections()
    {
        List<Sections> sections=sectionsRepository.findAll();
        List<SectionsDTO> sectionsDTOS=new ArrayList<>();
        for(Sections section: sections)
        {
            sectionsDTOS.add(sectionConvertToDTO(section));
        }
        return sectionsDTOS;
    }

    public Sections saveSections(Sections sections)
    {
        return sectionsRepository.save(sections);
    }


    public List<SectionsDTO> getByStudentIDorTeacherID(String type,String id)
    {
        if(type.equals("student"))
        {
            Students students=studentsRepository.findByStudentID(id);
            List<Enrollment> enrollments=enrollmentRepository.findByStudentsId(students.getId());
            List<SectionsDTO> sectionsDTOS=new ArrayList<>();
            for(Enrollment enrollment:enrollments)
            {
                sectionsDTOS.add(sectionConvertToDTO(enrollment.getSections()));
            }
            return sectionsDTOS;
        }
        else if(type.equals("teacher"))
        {
            Teachers teachers=teachersRepository.findByTeacherID(id);
            List<Enrollment> enrollments=enrollmentRepository.findByTeachersId(teachers.getId());
            List<SectionsDTO> sectionsDTOS=new ArrayList<>();
            for(Enrollment enrollment:enrollments)
            {
                sectionsDTOS.add(sectionConvertToDTO(enrollment.getSections()));
            }
            return sectionsDTOS;
        }
        else
        {
            return null;
        }
    }



    public SectionsDTO sectionConvertToDTO(Sections section)
    {
        ClassroomDTO classroomDTO=new ClassroomDTO();
        classroomDTO.setId(section.getClassroom().getId());
        classroomDTO.setRoomNumber(section.getClassroom().getRoomNumber());

        SubjectsDTO subjectsDTO=new SubjectsDTO();
        subjectsDTO.setId(section.getSubjects().getId());
        subjectsDTO.setCode(section.getSubjects().getCode());
        subjectsDTO.setName(section.getSubjects().getName());


        SectionsDTO sectionsDTO=new SectionsDTO();
        sectionsDTO.setId(section.getId());
        sectionsDTO.setName(section.getName());
        sectionsDTO.setDay(section.getDay());
        sectionsDTO.setTime(section.getTime());
        sectionsDTO.setClassroom(classroomDTO);
        sectionsDTO.setSubjects(subjectsDTO);

        return sectionsDTO;
    }

//    public SectionsDTO sectionsConvertToDTOWithSubjectClassroom(Enrollment enrollment)
//    {
//        ClassroomDTO classroomDTO=new ClassroomDTO();
//        classroomDTO.setId(enrollment.getSections().getClassroom().getId());
//        classroomDTO.setRoomNumber(enrollment.getSections().getClassroom().getRoomNumber());
//
//        SubjectsDTO subjectsDTO=new SubjectsDTO();
//        subjectsDTO.setId(enrollment.getSections().getSubjects().getId());
//        subjectsDTO.setCode(enrollment.getSections().getSubjects().getCode());
//        subjectsDTO.setName(enrollment.getSections().getSubjects().getName());
//
//        SectionsDTO sectionsDTO=new SectionsDTO();
//        sectionsDTO.setId(enrollment.getSections().getId());
//        sectionsDTO.setDay(enrollment.getSections().getDay());
//        sectionsDTO.setTime(enrollment.getSections().getTime());
//        sectionsDTO.setClassroom(classroomDTO);
//        sectionsDTO.setSubjects(subjectsDTO);
//        return sectionsDTO;
//    }
}
