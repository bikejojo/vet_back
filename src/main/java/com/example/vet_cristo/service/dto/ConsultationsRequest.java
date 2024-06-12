package com.example.vet_cristo.service.dto;


import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationsRequest {

    private String id;
    private String patientId;
    private String DoctorId;
    private String date;
    private double weight;
    private int height;
    private double temperature;
    private int heartRate;
    private int respiratoryRate;
    private String diagnosis;
    private String treatment;
    private String notes;

}
