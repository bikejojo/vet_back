package com.example.vet_cristo.repository;

import com.example.vet_cristo.model.Consultations;
import com.example.vet_cristo.model.Visits;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ConsultationsRepository extends MongoRepository<Consultations, String> {

    @Query("{ 'patientId' : ?0 }")
    List<Consultations> getConsulByIdPatient(String patientId);
}
