package com.example.springbootstudentmanagement.service;


import com.example.springbootstudentmanagement.dto.RolesDTO;
import com.example.springbootstudentmanagement.dto.StudentsDTO;
import com.example.springbootstudentmanagement.model.Roles;
import com.example.springbootstudentmanagement.model.Students;
import com.example.springbootstudentmanagement.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    public List<StudentsDTO> getAllStudents()
    {
        List<Students> students=studentsRepository.findAll();
        List<StudentsDTO> studentsDTOS=new ArrayList<>();

        for(Students student:students)
        {
            studentsDTOS.add(studentConvertToDTO(student));
        }
        return studentsDTOS;
    }

    public Students saveStudent(Students students)
    {
        return studentsRepository.save(students);
    }

    public StudentsDTO StudentById(Long id)
    {
        return studentConvertToDTO(studentsRepository.findById(id).orElse(null));
    }

    public StudentsDTO studentConvertToDTO(Students students)
    {
        List<RolesDTO> rolesDTOS=new ArrayList<>();
        for(Roles role:students.getRoles())
        {
            RolesDTO rolesDTO=new RolesDTO();
            rolesDTO.setId(role.getId());
            rolesDTO.setName(role.getName());
            rolesDTOS.add(rolesDTO);
        }
        StudentsDTO studentsDTO=new StudentsDTO();
        studentsDTO.setId(students.getId());
        studentsDTO.setFirstName(students.getFirstName());
        studentsDTO.setLastName(students.getLastName());
        studentsDTO.setFatherName(students.getFatherName());
        studentsDTO.setMotherName(students.getMotherName());
        studentsDTO.setStudentID(students.getStudentID());
        studentsDTO.setPassword(null);
        studentsDTO.setDateOfBirth(students.getDateOfBirth());
        studentsDTO.setAddress(students.getAddress());
        studentsDTO.setGender(students.getGender());
        studentsDTO.setPhone(students.getPhone());
        studentsDTO.setDateOfJoin(students.getDateOfJoin());
        studentsDTO.setUsername(students.getUsername());
        studentsDTO.setRoles(rolesDTOS);
        return studentsDTO;
    }
}
