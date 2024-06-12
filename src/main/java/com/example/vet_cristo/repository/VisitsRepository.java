package com.example.vet_cristo.repository;

import com.example.vet_cristo.model.Pet;
import com.example.vet_cristo.model.Visits;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface VisitsRepository extends MongoRepository<Visits, String> {
    @Query("{ 'reserved' : ?0 }")
    List<Visits> getVisitsByReserve(Boolean reserved);

    @Query("{ 'idDoctor' : ?0 }")
    List<Visits> getVisitsByIdDoctor(String idDoctor);
}
