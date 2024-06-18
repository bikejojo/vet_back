package com.example.vet_cristo;

import com.example.vet_cristo.model.Analysis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.vet_cristo.repository.AnalysisRepository;

import java.util.List;


@Slf4j
@SpringBootApplication
public class VetCristoApplication {

    public static void main(String[] args) {

        SpringApplication.run(VetCristoApplication.class, args);
        log.info("Hola mundo.........");

    }

}
