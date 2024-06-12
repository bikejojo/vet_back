package com.example.vet_cristo.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Setter
@Getter
@Document(collection = "consultations")
public class Consultations {

    @Id
    private String id;

    private String patientId;
    private String doctorId;
    private Date date;
    private double weight;
    private int height;
    private double temperature;
    private int heartRate;
    private int respiratoryRate;
    private String diagnosis;
    private String treatment;
    private String notes;

}
