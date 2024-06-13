package com.example.vet_cristo.controller;


import com.example.vet_cristo.model.Rol;
import com.example.vet_cristo.model.Users;
import com.example.vet_cristo.service.RolService;
import com.example.vet_cristo.service.UserService;
import com.example.vet_cristo.service.dto.RolRequest;
import com.example.vet_cristo.service.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO')  ")
    @QueryMapping
    public Optional<Users> getUserById(@Argument String id) {

        return userService.getUserById(id);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO') ")
    @QueryMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO')  ")
    @MutationMapping
    public Users createUser(@Argument UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

}
