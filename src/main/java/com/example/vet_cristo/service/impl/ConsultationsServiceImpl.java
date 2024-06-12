package com.example.vet_cristo.service.impl;
import com.example.vet_cristo.model.Consultations;
import com.example.vet_cristo.repository.ConsultationsRepository;
import com.example.vet_cristo.service.ConsultationsService;
import com.example.vet_cristo.service.dto.ConsultationsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ConsultationsServiceImpl implements ConsultationsService {

    @Autowired
    private ConsultationsRepository consultationsRepository;


    @Override
    public Consultations createConsultations(ConsultationsRequest consultationsRequest) {

        Consultations newConsultation = new Consultations();
        newConsultation.setPatientId(consultationsRequest.getPatientId());
        newConsultation.setDoctorId(consultationsRequest.getDoctorId());
        newConsultation.setDate(new Date());
        newConsultation.setWeight(consultationsRequest.getWeight());
        newConsultation.setHeight(consultationsRequest.getHeight());
        newConsultation.setTemperature(consultationsRequest.getTemperature());
        newConsultation.setHeartRate(consultationsRequest.getHeartRate());
        newConsultation.setRespiratoryRate(consultationsRequest.getRespiratoryRate());
        newConsultation.setDiagnosis(consultationsRequest.getDiagnosis());
        newConsultation.setTreatment(consultationsRequest.getTreatment());
        newConsultation.setNotes(consultationsRequest.getNotes());

        return consultationsRepository.save(newConsultation);
    }

    @Override
    public void deleteConsultations(String id) {
        Optional<Consultations> existingConsultationssOptional = consultationsRepository.findById(id);
        if (existingConsultationssOptional.isPresent()) {
            consultationsRepository.deleteById(id);
        }
    }

    @Override
    public List<Consultations> getConsultationsByIdPatient(String id) {
        return consultationsRepository.getConsulByIdPatient(id);
    }


}
