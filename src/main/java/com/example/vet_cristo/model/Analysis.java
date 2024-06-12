package com.example.vet_cristo.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Setter
@Getter
@Document(collection = "analysis")
public class Analysis {

    @Id
    private String id;
    private String patientId;
    private String analysisType;
    private String results;
    private Date analysisDate;
    private String notes;

}
