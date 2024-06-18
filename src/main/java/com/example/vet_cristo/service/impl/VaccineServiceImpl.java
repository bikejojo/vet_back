package com.example.vet_cristo.service.impl;
import com.example.vet_cristo.model.Analysis;
import com.example.vet_cristo.model.Vaccine;
import com.example.vet_cristo.repository.VaccineRepository;
import com.example.vet_cristo.service.VaccineService;
import com.example.vet_cristo.service.dto.VaccineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public List<Vaccine> getAllVaccine() {
        return vaccineRepository.findAll();
    }

    @Override
    public Vaccine createVaccine(VaccineRequest vaccineRequest)  throws ParseException{
        /*Vaccine newVaccine = new Vaccine();

        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date formattedDateTime = dateTimeFormat.parse(vaccineRequest.getNextAdministeredDate());

        newVaccine.setAdministeredDate(new Date());
        newVaccine.setPatientId(vaccineRequest.getPatientId());
        newVaccine.setDoses(vaccineRequest.getDoses());
        newVaccine.setVaccineName(vaccineRequest.getVaccineName());
        newVaccine.setNextAdministeredDate(formattedDateTime);

        return vaccineRepository.save(newVaccine);*/
        Vaccine newVaccine = new Vaccine();

        // Usar DateTimeFormatter para parsear la fecha en formato ISO 8601
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(vaccineRequest.getNextAdministeredDate(), formatter);
        Date formattedDateTime = Date.from(offsetDateTime.toInstant());

        newVaccine.setAdministeredDate(new Date()); // o usar la fecha proporcionada si es diferente
        newVaccine.setPatientId(vaccineRequest.getPatientId());
        newVaccine.setDoses(vaccineRequest.getDoses());
        newVaccine.setVaccineName(vaccineRequest.getVaccineName());
        newVaccine.setNextAdministeredDate(formattedDateTime);

        return vaccineRepository.save(newVaccine);
    }

    @Override
    public void deleteVaccine(String id) {
        Optional<Vaccine> existingVaccinesOptional = vaccineRepository.findById(id);
        if (existingVaccinesOptional.isPresent()) {
            vaccineRepository.deleteById(id);
        }
    }


    @Override
    public List<Vaccine> getVaccineByIdPatient(String id) {
       // return vaccineRepository.getVaccineByPatientId(id);
        List<Vaccine> analyses = vaccineRepository.getVaccineByPatientId(id);
        analyses.forEach(System.out::println);  // Esto debería imprimir todos los análisis encontrados
        for (Vaccine analysis : analyses) {
            System.out.println("Análisis encontrado: " + analysis);
            if (analysis.getPatientId() == null) {
                analysis.setPatientId("Unknown");
            }
            if (analysis.getVaccineName() == null) {
                analysis.setVaccineName("Unknow");
            }
            if (analysis.getDoses() == 0) {
                analysis.setDoses(0);
            }
        }
        return analyses.stream()
                .filter(a -> a.getPatientId() != null && a.getVaccineName() != null && a.getDoses() != 0)
                .collect(Collectors.toList());
    }

}
