package com.example.vet_cristo.controller;


import com.example.vet_cristo.model.Consultations;
import com.example.vet_cristo.model.Vaccine;
import com.example.vet_cristo.service.VaccineService;
import com.example.vet_cristo.service.VaccineService;
import com.example.vet_cristo.service.dto.ConsultationsRequest;
import com.example.vet_cristo.service.dto.VaccineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;

@Controller
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO')  ")
    @MutationMapping
    public Vaccine createVaccine(@Argument VaccineRequest vaccineRequest) throws ParseException {
        return vaccineService.createVaccine(vaccineRequest);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO')  ")
    @QueryMapping
    public List<Vaccine> getAllVaccines() {
        return vaccineService.getAllVaccine();
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO') or hasRole('CLIENTE') ")
    @QueryMapping
    public List<Vaccine> getVaccineByIdPatient(@Argument String id) {
        return vaccineService.getVaccineByIdPatient(id);
    }

}
