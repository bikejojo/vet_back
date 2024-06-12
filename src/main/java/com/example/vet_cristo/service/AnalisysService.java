package com.example.vet_cristo.service;

import com.example.vet_cristo.model.Analysis;
import com.example.vet_cristo.service.dto.AnalysisRequest;

import java.text.ParseException;
import java.util.List;

public interface AnalisysService {

    List<Analysis> getAllAnalysis();

    Analysis createAnalysis(AnalysisRequest analysisRequest) throws ParseException;

    List<Analysis> getAnalysisByIdPatient(String id);

    void deleteAnalysis(String id);
}
