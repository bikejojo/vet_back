package com.example.vet_cristo.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Setter
@Getter
@Document(collection = "vaccines")
public class Vaccine {

    @Id
    private String id;
    private String patientId;
    private String vaccineName;
    private Date administeredDate;
    private Date nextAdministeredDate;
    private int doses;
}
