package com.example.vet_cristo.service.impl;
import com.example.vet_cristo.model.Vaccine;
import com.example.vet_cristo.repository.VaccineRepository;
import com.example.vet_cristo.service.VaccineService;
import com.example.vet_cristo.service.dto.VaccineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


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
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date formattedDateTime = dateTimeFormat.parse(vaccineRequest.getNextAdministeredDate());

        Vaccine newVaccine = new Vaccine();
        newVaccine.setAdministeredDate(new Date());
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
        return vaccineRepository.getVaccineByPatientId(id);
    }


}
