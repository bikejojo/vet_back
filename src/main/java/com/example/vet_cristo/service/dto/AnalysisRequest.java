package com.example.vet_cristo.service.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisRequest {

    private String id;
    private String patientId;
    private String analysisType;
    private String results;
    private String analysisDate;
    private String notes;

}
