package com.anket.controllers;

import com.anket.entities.Answer;
import com.anket.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/answers")
@CrossOrigin(origins = "*")
public class AnswerController {
    
    @Autowired
    private AnswerService answerService;
    
    @GetMapping
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        Optional<Answer> answer = answerService.getAnswerById(id);
        if (answer.isPresent()) {
            return ResponseEntity.ok(answer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Answer createAnswer(@RequestBody Answer answer) {
        return answerService.createAnswer(answer);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable Long id, @RequestBody Answer answerDetails) {
        try {
            Answer updatedAnswer = answerService.updateAnswer(id, answerDetails);
            return ResponseEntity.ok(updatedAnswer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        try {
            answerService.deleteAnswer(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}