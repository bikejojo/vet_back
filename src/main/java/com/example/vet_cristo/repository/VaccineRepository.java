package com.example.vet_cristo.repository;

import com.example.vet_cristo.model.Vaccine;
import com.example.vet_cristo.model.Visits;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface VaccineRepository extends MongoRepository<Vaccine, String> {

    @Query("{ 'patientId' : ?0 }")
    List<Vaccine> getVaccineByPatientId(String patientId);
}
