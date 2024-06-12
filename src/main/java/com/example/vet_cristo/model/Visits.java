package com.example.vet_cristo.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Setter
@Getter
@Document(collection = "visits")
public class Visits {

    @Id
    private String id;
    private Date date;
    private String reason;
    private String idPatient;
    private String idDoctor;
    private String status;
    private Boolean reserved;
}
