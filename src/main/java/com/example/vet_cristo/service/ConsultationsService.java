package com.example.vet_cristo.service;

import com.example.vet_cristo.model.Consultations;
import com.example.vet_cristo.service.dto.ConsultationsRequest;

import java.text.ParseException;
import java.util.List;

public interface ConsultationsService {


    Consultations createConsultations(ConsultationsRequest consultationsRequest) throws ParseException;

    void deleteConsultations(String id);

    List<Consultations> getConsultationsByIdPatient(String id);
}
