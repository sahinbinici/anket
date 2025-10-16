package com.anket.controllers;

import com.anket.entities.Survey;
import com.anket.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/surveys")
@CrossOrigin(origins = "*")
public class SurveyController {
    
    @Autowired
    private SurveyService surveyService;
    
    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }
    
    @GetMapping("/active")
    public List<Survey> getActiveSurveys() {
        return surveyService.getActiveSurveys();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        Optional<Survey> survey = surveyService.getSurveyById(id);
        if (survey.isPresent()) {
            return ResponseEntity.ok(survey.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyService.createSurvey(survey);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Long id, @RequestBody Survey surveyDetails) {
        try {
            Survey updatedSurvey = surveyService.updateSurvey(id, surveyDetails);
            return ResponseEntity.ok(updatedSurvey);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        try {
            surveyService.deleteSurvey(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}