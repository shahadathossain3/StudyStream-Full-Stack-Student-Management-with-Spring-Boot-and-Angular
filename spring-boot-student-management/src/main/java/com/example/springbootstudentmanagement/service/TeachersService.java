package com.example.springbootstudentmanagement.service;


import com.example.springbootstudentmanagement.dto.TeachersDTO;
import com.example.springbootstudentmanagement.model.Teachers;
import com.example.springbootstudentmanagement.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeachersService {

    @Autowired
    private TeachersRepository teachersRepository;

    public List<TeachersDTO> getAllTeachers()
    {
        List<Teachers> teachers=teachersRepository.findAll();
        List<TeachersDTO> teachersDTOS=new ArrayList<>();
        for(Teachers teacher:teachers)
        {
            teachersDTOS.add(teachersConvertToDTO(teacher));
        }
        return teachersDTOS;
    }

    public Teachers saveTeachers(Teachers teachers)
    {
        return teachersRepository.save(teachers);
    }


    public TeachersDTO teachersConvertToDTO(Teachers teachers)
    {
        TeachersDTO teachersDTO=new TeachersDTO();
        teachersDTO.setId(teachers.getId());
        teachersDTO.setFirstName(teachers.getFirstName());
        teachersDTO.setLastName(teachers.getLastName());
        teachersDTO.setTeacherID(teachers.getTeacherID());
        teachersDTO.setPassword(null);
        teachersDTO.setGender(teachers.getGender());
        teachersDTO.setAddress(teachers.getAddress());
        teachersDTO.setMobile(teachers.getMobile());
        teachersDTO.setDateOfJoin(teachers.getDateOfJoin());
        return teachersDTO;
    }


}
