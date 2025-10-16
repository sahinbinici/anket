package com.anket.services;

import com.anket.entities.Response;
import com.anket.entities.Survey;
import com.anket.entities.User;
import com.anket.repositories.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {
    
    @Autowired
    private ResponseRepository responseRepository;
    
    public List<Response> getAllResponses() {
        return responseRepository.findAll();
    }
    
    public List<Response> getResponsesBySurvey(Survey survey) {
        return responseRepository.findBySurvey(survey);
    }
    
    public List<Response> getResponsesByRespondent(User respondent) {
        return responseRepository.findByRespondent(respondent);
    }
    
    public List<Response> getResponsesBySurveyAndRespondent(Survey survey, User respondent) {
        return responseRepository.findBySurveyAndRespondent(survey, respondent);
    }
    
    public Optional<Response> getResponseById(Long id) {
        return responseRepository.findById(id);
    }
    
    public Response createResponse(Response response) {
        return responseRepository.save(response);
    }
    
    public Response updateResponse(Long id, Response responseDetails) {
        Response response = responseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Response not found with id: " + id));
        
        response.setSubmittedAt(responseDetails.getSubmittedAt());
        
        return responseRepository.save(response);
    }
    
    public void deleteResponse(Long id) {
        Response response = responseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Response not found with id: " + id));
        responseRepository.delete(response);
    }
}