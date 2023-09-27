package com.example.springbootstudentmanagement.repository;

import com.example.springbootstudentmanagement.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    List<Roles> findByName(String role);
}
