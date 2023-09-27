package com.example.springbootstudentmanagement.controller;


import com.example.springbootstudentmanagement.dto.ClassroomDTO;
import com.example.springbootstudentmanagement.model.Classroom;
import com.example.springbootstudentmanagement.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("classroom/")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("getClassroomList")
    public ResponseEntity<?> getAllClassroomList()
    {
        return ResponseEntity.ok().body(classroomService.getAllClassrooms());
    }

    @PostMapping("addClassroom")
    public ResponseEntity<?> addClassroom(@RequestBody ClassroomDTO classroomDTO)
    {

        return ResponseEntity.ok().body(classroomService.saveClassroom(classroomConvertFormDTO(classroomDTO)));
    }

    public Classroom classroomConvertFormDTO(ClassroomDTO classroomDTO)
    {
        Classroom classroom=new Classroom();
        classroom.setRoomNumber(classroomDTO.getRoomNumber());
        return classroom;
    }
}
