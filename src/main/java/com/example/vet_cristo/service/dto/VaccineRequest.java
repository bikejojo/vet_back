package com.example.vet_cristo.service.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccineRequest {

    private String id;
    private String patientId;
    private String vaccineName;
    private String administeredDate;
    private String nextAdministeredDate;
    private int doses;

}
