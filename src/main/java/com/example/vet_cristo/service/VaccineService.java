package com.example.vet_cristo.service;

import com.example.vet_cristo.model.Vaccine;
import com.example.vet_cristo.model.Visits;
import com.example.vet_cristo.service.dto.VaccineRequest;
import com.example.vet_cristo.service.dto.VisitsRequest;

import java.text.ParseException;
import java.util.List;

public interface VaccineService {

    List<Vaccine> getAllVaccine();

    Vaccine createVaccine(VaccineRequest vaccineVisitsRequest) throws ParseException;

    List<Vaccine> getVaccineByIdPatient(String id);

    void deleteVaccine(String id);
}
