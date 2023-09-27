package com.example.springbootstudentmanagement.service;

import com.example.springbootstudentmanagement.dto.ClassroomDTO;
import com.example.springbootstudentmanagement.model.Classroom;
import com.example.springbootstudentmanagement.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public List<ClassroomDTO> getAllClassrooms()
    {
        List<Classroom> classrooms=classroomRepository.findAll();
        List<ClassroomDTO> classroomDTOS=new ArrayList<>();
        for(Classroom classroom:classrooms)
        {

            classroomDTOS.add(classroomConvertToDTO(classroom));
        }
        return classroomDTOS;
    }

    public Classroom saveClassroom(Classroom classroom)
    {
        return classroomRepository.save(classroom);
    }

    public ClassroomDTO classroomConvertToDTO(Classroom classroom)
    {
        ClassroomDTO classroomDTO=new ClassroomDTO();
        classroomDTO.setId(classroom.getId());
        classroomDTO.setRoomNumber(classroom.getRoomNumber());
        return classroomDTO;
    }

}
