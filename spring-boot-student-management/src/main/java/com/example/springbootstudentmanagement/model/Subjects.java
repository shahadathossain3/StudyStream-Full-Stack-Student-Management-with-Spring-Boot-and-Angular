package com.example.springbootstudentmanagement.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    @OneToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
    private List<Sections> sections;
    @OneToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
    private List<Result> results;

    public Subjects() {
    }

    public Subjects(Long id, String name, String code, List<Sections> sections, List<Result> results) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.sections = sections;
        this.results = results;
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

    public List<Sections> getSections() {
        return sections;
    }

    public void setSections(List<Sections> sections) {
        this.sections = sections;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
