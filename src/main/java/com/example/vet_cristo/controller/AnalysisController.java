package com.example.vet_cristo.controller;


import com.example.vet_cristo.model.Analysis;
import com.example.vet_cristo.service.AnalisysService;
import com.example.vet_cristo.service.dto.AnalysisRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;

@Controller
public class AnalysisController {

    @Autowired
    private AnalisysService analysisService;


    @MutationMapping
    public Analysis createAnalysis(@Argument AnalysisRequest analysisRequest) throws ParseException {
        return analysisService.createAnalysis(analysisRequest);
    }

    @QueryMapping
    public List<Analysis> getAllAnalysis() {
        return analysisService.getAllAnalysis();
    }

    @QueryMapping
    public List<Analysis> getAnalysisByIdPatient(@Argument String id) {
        return analysisService.getAnalysisByIdPatient(id);
    }



}
