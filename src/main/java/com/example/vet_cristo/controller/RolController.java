package com.example.vet_cristo.controller;


import com.example.vet_cristo.model.Rol;
import com.example.vet_cristo.service.RolService;
import com.example.vet_cristo.service.dto.RolRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Slf4j
@Controller
public class RolController {

    @Autowired
    private RolService rolService;

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @QueryMapping
    public Optional<Rol> getRolById(@Argument String id) {
        return rolService.getRolById(id);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @QueryMapping
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles().stream() /*se actualizo para manejo de null*/
                .filter(rol -> rol.getName() != null && !rol.getName().trim().isEmpty())
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @MutationMapping
    public Rol createRol(@Argument RolRequest rolRequest) {
        Rol rol = new Rol();
        rol.setName(rolRequest.getName());
        return rolService.createRol(rol);
    }

}
