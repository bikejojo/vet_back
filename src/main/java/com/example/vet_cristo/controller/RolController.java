package com.example.vet_cristo.controller;


import com.example.vet_cristo.model.Rol;
import com.example.vet_cristo.service.RolService;
import com.example.vet_cristo.service.dto.RolRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Controller
public class RolController {

    @Autowired
    private RolService rolService;

    @QueryMapping
    public Optional<Rol> getRolById(@Argument String id) {
        return rolService.getRolById(id);
    }

    @QueryMapping
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles().stream() /*se actualizo para manejo de null*/
                .filter(rol -> rol.getName() != null && !rol.getName().trim().isEmpty())
                .collect(Collectors.toList());
    }

    @MutationMapping
    public Rol createRol(@Argument RolRequest rolRequest) {
        Rol rol = new Rol();
        rol.setName(rolRequest.getName());
        return rolService.createRol(rol);
    }

}
