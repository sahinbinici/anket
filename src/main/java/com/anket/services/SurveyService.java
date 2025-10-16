package com.anket.services;

import com.anket.entities.Survey;
import com.anket.entities.User;
import com.anket.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    
    @Autowired
    private SurveyRepository surveyRepository;
    
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }
    
    public List<Survey> getActiveSurveys() {
        return surveyRepository.findByIsActiveTrue();
    }
    
    public List<Survey> getSurveysByCreator(User creator) {
        return surveyRepository.findByCreator(creator);
    }
    
    public Optional<Survey> getSurveyById(Long id) {
        return surveyRepository.findById(id);
    }
    
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }
    
    public Survey updateSurvey(Long id, Survey surveyDetails) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey not found with id: " + id));
        
        survey.setTitle(surveyDetails.getTitle());
        survey.setDescription(surveyDetails.getDescription());
        survey.setActive(surveyDetails.isActive());
        survey.setStartDate(surveyDetails.getStartDate());
        survey.setEndDate(surveyDetails.getEndDate());
        
        return surveyRepository.save(survey);
    }
    
    public void deleteSurvey(Long id) {
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey not found with id: " + id));
        surveyRepository.delete(survey);
    }
}