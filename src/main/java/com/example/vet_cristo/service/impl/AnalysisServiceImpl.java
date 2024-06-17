package com.example.vet_cristo.service.impl;

import com.example.vet_cristo.model.Analysis;
import com.example.vet_cristo.repository.AnalysisRepository;
import com.example.vet_cristo.service.AnalisysService;
import com.example.vet_cristo.service.dto.AnalysisRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class AnalysisServiceImpl implements AnalisysService {

    @Autowired
    private AnalysisRepository analysisRepository;

    @Override
    public List<Analysis> getAllAnalysis() {
        return analysisRepository.findAll();
    }

    @Override
    public Analysis createAnalysis(AnalysisRequest analysisRequest)  throws ParseException{
        Analysis newAnalysis = new Analysis();
        newAnalysis.setPatientId(analysisRequest.getPatientId());
        newAnalysis.setNotes(analysisRequest.getNotes());
        newAnalysis.setAnalysisType(analysisRequest.getAnalysisType());
        newAnalysis.setResults(analysisRequest.getResults());

        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date formattedDateTime = dateTimeFormat.parse(analysisRequest.getAnalysisDate());

        newAnalysis.setAnalysisDate(formattedDateTime);

        return analysisRepository.save(newAnalysis);
    }

    @Override
    public void deleteAnalysis(String id) {
        Optional<Analysis> existingAnalysissOptional = analysisRepository.findById(id);
        if (existingAnalysissOptional.isPresent()) {
            analysisRepository.deleteById(id);
        }
    }


    @Override
    public List<Analysis> getAnalysisByIdPatient(String id) {
        return analysisRepository.getAnalysisByPatientId(id);
    }


}
