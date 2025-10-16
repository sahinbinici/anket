package com.anket.services;

import com.anket.entities.Answer;
import com.anket.entities.Question;
import com.anket.entities.Response;
import com.anket.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    
    @Autowired
    private AnswerRepository answerRepository;
    
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }
    
    public List<Answer> getAnswersByQuestion(Question question) {
        return answerRepository.findByQuestion(question);
    }
    
    public List<Answer> getAnswersByResponse(Response response) {
        return answerRepository.findByResponse(response);
    }
    
    public Optional<Answer> getAnswerById(Long id) {
        return answerRepository.findById(id);
    }
    
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }
    
    public Answer updateAnswer(Long id, Answer answerDetails) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found with id: " + id));
        
        answer.setTextAnswer(answerDetails.getTextAnswer());
        answer.setSelectedOption(answerDetails.getSelectedOption());
        
        return answerRepository.save(answer);
    }
    
    public void deleteAnswer(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found with id: " + id));
        answerRepository.delete(answer);
    }
}