package com.example.vet_cristo.service.impl;
import com.example.vet_cristo.model.Visits;
import com.example.vet_cristo.repository.VisitsRepository;
import com.example.vet_cristo.repository.UserRepository;
import com.example.vet_cristo.repository.VisitsRepository;
import com.example.vet_cristo.service.VisitsService;
import com.example.vet_cristo.service.VisitsService;
import com.example.vet_cristo.service.dto.VisitsRequest;
import com.example.vet_cristo.service.dto.VisitsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class VisitsServiceImpl implements VisitsService {

    @Autowired
    private VisitsRepository visitsRepository;

    @Override
    public List<Visits> getAllVisits() {
        return visitsRepository.findAll();
    }

    @Override
    public Visits createVisits(VisitsRequest visitsRequest)  throws ParseException{
        //DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formattedDateTime = dateTimeFormat.parse(visitsRequest.getDate());

        Visits newVisits = new Visits();
        //newVisits.setDate(formattedDateTime);
        newVisits.setDate(formattedDateTime);
        newVisits.setReason(visitsRequest.getReason());
        newVisits.setIdPatient(visitsRequest.getIdPatient());
        newVisits.setIdDoctor(visitsRequest.getIdDoctor());
        //newVisits.setStatus(String.valueOf(VisitsStatus.PENDIENTE));
        newVisits.setStatus(visitsRequest.getStatus() != null ? visitsRequest.getStatus() : VisitsStatus.PENDIENTE.name());
        newVisits.setReserved(visitsRequest.getReserved());

        return visitsRepository.save(newVisits);
    }

    @Override
    public Visits updateVisits(String id, String status) {
        Optional<Visits> existingVisitssOptional = visitsRepository.findById(id);
        if ( existingVisitssOptional.isPresent()) {
            Visits existingVisitss = existingVisitssOptional.get();
            existingVisitss.setStatus(status);
            return visitsRepository.save(existingVisitss);
        }
        else {
            throw new RuntimeException("Visitss no encontrado con ID: " + id);
        }
    }

    @Override
    public void deleteVisits(String id) {
        Optional<Visits> existingVisitssOptional = visitsRepository.findById(id);
        if (existingVisitssOptional.isPresent()) {
            visitsRepository.deleteById(id);
        }
    }

    @Override
    public List<Visits> getVisitsByReserve(Boolean reserved) {
        return visitsRepository.getVisitsByReserve(reserved);
    }

    @Override
    public List<Visits> getVisitsByIdDoctor(String id) {
        return visitsRepository.getVisitsByIdDoctor(id);
    }


}
