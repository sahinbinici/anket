package com.anket.services;

import com.anket.entities.Question;
import com.anket.entities.Survey;
import com.anket.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    
    @Autowired
    private QuestionRepository questionRepository;
    
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    
    public List<Question> getQuestionsBySurvey(Survey survey) {
        return questionRepository.findBySurvey(survey);
    }
    
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }
    
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }
    
    public Question updateQuestion(Long id, Question questionDetails) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
        
        question.setText(questionDetails.getText());
        question.setType(questionDetails.getType());
        question.setRequired(questionDetails.isRequired());
        question.setDisplayOrder(questionDetails.getDisplayOrder());
        
        return questionRepository.save(question);
    }
    
    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
        questionRepository.delete(question);
    }
}