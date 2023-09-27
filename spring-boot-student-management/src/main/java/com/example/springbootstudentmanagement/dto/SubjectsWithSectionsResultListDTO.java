package com.example.springbootstudentmanagement.dto;

import java.util.List;

public class SubjectsWithSectionsResultListDTO {
    private Long id;
    private String name;
    private String code;
    private List<SectionsDTO> sections;
    private List<ResultDTO> result;

    public SubjectsWithSectionsResultListDTO() {
    }

    public SubjectsWithSectionsResultListDTO(Long id, String name, String code, List<SectionsDTO> sections, List<ResultDTO> result) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.sections = sections;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<SectionsDTO> getSections() {
        return sections;
    }

    public void setSections(List<SectionsDTO> sections) {
        this.sections = sections;
    }

    public List<ResultDTO> getResult() {
        return result;
    }

    public void setResult(List<ResultDTO> result) {
        this.result = result;
    }
}
