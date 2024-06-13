package com.example.vet_cristo.repository;

import com.example.vet_cristo.model.Users;
import com.example.vet_cristo.model.Visits;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends MongoRepository<Users, String> {


    @Query("{ 'email' : ?0 }")
    Optional<Users> findByEmail(String email);
}
