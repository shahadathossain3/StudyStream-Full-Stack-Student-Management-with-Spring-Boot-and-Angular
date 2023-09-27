package com.example.springbootstudentmanagement.dto;

import java.util.List;

public class UsersDTO {
    private Long id;
    private String username;
    private String password;
    private List<RolesDTO> roles;

    public UsersDTO() {
    }

    public UsersDTO(Long id, String username, String password, List<RolesDTO> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RolesDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesDTO> roles) {
        this.roles = roles;
    }
}
