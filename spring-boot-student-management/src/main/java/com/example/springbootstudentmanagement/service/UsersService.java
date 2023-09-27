package com.example.springbootstudentmanagement.service;


import com.example.springbootstudentmanagement.dto.RolesDTO;
import com.example.springbootstudentmanagement.dto.UsersDTO;
import com.example.springbootstudentmanagement.model.Roles;
import com.example.springbootstudentmanagement.model.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    public UsersDTO userConvertDTO(Users users)
    {
        UsersDTO usersDTO=new UsersDTO();
        List<RolesDTO> rolesDTOS=new ArrayList<>();
        for(Roles roles:users.getRoles())
        {
            RolesDTO rolesDTO=new RolesDTO();
            rolesDTO.setId(roles.getId());
            rolesDTO.setName(roles.getName());
            rolesDTOS.add(rolesDTO);
        }
        usersDTO.setId(users.getId());
        usersDTO.setPassword(null);
        usersDTO.setUsername(users.getUsername());
        usersDTO.setRoles(rolesDTOS);
        return usersDTO;
    }
}
