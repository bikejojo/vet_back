package com.example.vet_cristo.service;

import com.example.vet_cristo.model.Visits;
import com.example.vet_cristo.service.dto.VisitsRequest;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface VisitsService {

    List<Visits> getAllVisits();

    Visits createVisits(VisitsRequest visitsRequest) throws ParseException;

    void deleteVisits(String id);

    Visits updateVisits(String id, String status);

    List<Visits> getVisitsByReserve(Boolean reserved);

    List<Visits> getVisitsByIdDoctor(String id);
}
