package com.example.springbootstudentmanagement.service;

import com.example.springbootstudentmanagement.model.Roles;
import com.example.springbootstudentmanagement.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> getRoleByName(String name)
    {
        return rolesRepository.findByName(name);
    }
}
