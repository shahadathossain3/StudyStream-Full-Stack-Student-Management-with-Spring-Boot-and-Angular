package com.example.springbootstudentmanagement.service;


import com.example.springbootstudentmanagement.dto.*;
import com.example.springbootstudentmanagement.model.Result;
import com.example.springbootstudentmanagement.model.Sections;
import com.example.springbootstudentmanagement.model.Subjects;
import com.example.springbootstudentmanagement.repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectsService {
    @Autowired
    private SubjectsRepository subjectsRepository;

    public List<SubjectsWithSectionsResultListDTO> getAllSubjects()
    {
        List<Subjects> subjects=subjectsRepository.findAll();
        List<SubjectsWithSectionsResultListDTO> subjectsWithSectionsResultListDTOS=new ArrayList<>();
        for(Subjects subject:subjects)
        {
            subjectsWithSectionsResultListDTOS.add(subjectsConvertDTO(subject));
        }
        return subjectsWithSectionsResultListDTOS;
    }

    public Subjects saveSubjects(Subjects subjects)
    {
        return subjectsRepository.save(subjects);
    }


    public SubjectsWithSectionsResultListDTO subjectsConvertDTO(Subjects subjects)
    {
        List<SectionsDTO> sectionsDTOS=new ArrayList<>();
        for(Sections section: subjects.getSections())
        {
            SectionsDTO sectionsDTO=new SectionsDTO();
            sectionsDTO.setId(section.getId());
            sectionsDTO.setName(section.getName());
            sectionsDTO.setDay(section.getDay());
            sectionsDTO.setTime(section.getTime());
            sectionsDTOS.add(sectionsDTO);
        }

        List<ResultDTO> resultDTOS=new ArrayList<>();
        for (Result result:subjects.getResults())
        {
            ResultDTO resultDTO=new ResultDTO();
            resultDTO.setId(result.getId());
            resultDTO.setComment(result.getComment());
            resultDTO.setMarks(result.getMarks());
            resultDTOS.add(resultDTO);
        }

        SubjectsWithSectionsResultListDTO subjectsWithSectionsResultListDTO=new SubjectsWithSectionsResultListDTO();
        subjectsWithSectionsResultListDTO.setId(subjects.getId());
        subjectsWithSectionsResultListDTO.setCode(subjects.getCode());
        subjectsWithSectionsResultListDTO.setName(subjects.getName());
        subjectsWithSectionsResultListDTO.setSections(sectionsDTOS);
        subjectsWithSectionsResultListDTO.setResult(resultDTOS);
        return subjectsWithSectionsResultListDTO;
    }
}
