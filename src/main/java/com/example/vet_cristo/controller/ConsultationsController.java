package com.example.vet_cristo.controller;


import com.example.vet_cristo.model.Consultations;
import com.example.vet_cristo.model.Consultations;
import com.example.vet_cristo.service.ConsultationsService;
import com.example.vet_cristo.service.ConsultationsService;
import com.example.vet_cristo.service.dto.ConsultationsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;

@Controller
public class ConsultationsController {

    @Autowired
    private ConsultationsService consultationsService;


    @MutationMapping
    public Consultations createConsultations(@Argument ConsultationsRequest consultationsRequest) throws ParseException {
        return consultationsService.createConsultations(consultationsRequest);
    }

    @QueryMapping
    public List<Consultations> getConsultationsByIdPatient(@Argument String id) {
        return consultationsService.getConsultationsByIdPatient(id);
    }



}
