package com.example.vet_cristo.controller;


import com.example.vet_cristo.model.Visits;
import com.example.vet_cristo.service.VisitsService;
import com.example.vet_cristo.service.VisitsService;
import com.example.vet_cristo.service.dto.VisitsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Controller
public class VisitsController {

    @Autowired
    private VisitsService visitsService;

    //@PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO')  ")
    @QueryMapping
    public List<Visits> getAllVisits() {
        return visitsService.getAllVisits();
    }

    //@PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO') or hasRole('CLIENTE') ")
    @MutationMapping
    public Visits createVisits(@Argument VisitsRequest visitsRequest) throws ParseException {
        return visitsService.createVisits(visitsRequest);
    }

    //@PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO') or hasRole('CLIENTE') ")
    @MutationMapping
    public Visits updateVisits(@Argument String id, @Argument String status) {
        return visitsService.updateVisits(id, status);
    }

    //@PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO')  ")
    @QueryMapping
    public List<Visits> getVisitsByDoctor(@Argument String idDoctor) {
        return visitsService.getVisitsByIdDoctor(idDoctor);
    }

    //@PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO') or hasRole('CLIENTE') ")
    @QueryMapping
    public List<Visits> getVisitsByReserved(@Argument Boolean reserved) {
        return visitsService.getVisitsByReserve(reserved);
    }

}
