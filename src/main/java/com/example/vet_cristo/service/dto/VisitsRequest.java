package com.example.vet_cristo.service.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitsRequest {

    private String id;
    private String date;
    private String reason;
    private String idPatient;
    private String idDoctor;
    private String status;
    private Boolean reserved;

}
