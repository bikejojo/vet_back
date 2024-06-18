package com.example.vet_cristo.controller;


import com.example.vet_cristo.model.Analysis;
import com.example.vet_cristo.service.AnalisysService;
import com.example.vet_cristo.service.dto.AnalysisRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AnalysisController {

    @Autowired
    private AnalisysService analysisService;

    //@PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO') ")
    @MutationMapping
    public Analysis createAnalysis(@Argument AnalysisRequest analysisRequest) throws ParseException {
        return analysisService.createAnalysis(analysisRequest);
    }

    //@PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO')  ")
    @QueryMapping
    public List<Analysis> getAllAnalysis() {
        return analysisService.getAllAnalysis();
    }

    //@PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('VETERINARIO') or hasRole('CLIENTE') ")
    @QueryMapping
    public List<Analysis> getAnalysisByIdPatient(@Argument String id) {
        List<Analysis> analyses = analysisService.getAnalysisByIdPatient(id);
        analyses.forEach(System.out::println);  // Añadir para verificar los datos
        return analyses.stream()
                .peek(analysis -> {
                    if (analysis.getPatientId() == null || analysis.getAnalysisType() == null || analysis.getResults() == null) {
                        System.err.println("Datos inválidos: " + analysis);
                    }
                })
                .collect(Collectors.toList());
    }
}
