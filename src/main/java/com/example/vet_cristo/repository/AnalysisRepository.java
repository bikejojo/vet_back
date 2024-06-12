package com.example.vet_cristo.repository;

import com.example.vet_cristo.model.Analysis;
import com.example.vet_cristo.model.Vaccine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface AnalysisRepository extends MongoRepository<Analysis, String> {

    @Query("{ 'patientId' : ?0 }")
    List<Analysis> getAnalysisByPatientId(String patientId);
}
