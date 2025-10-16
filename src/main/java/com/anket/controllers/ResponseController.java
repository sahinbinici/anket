package com.anket.controllers;

import com.anket.entities.Response;
import com.anket.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/responses")
@CrossOrigin(origins = "*")
public class ResponseController {
    
    @Autowired
    private ResponseService responseService;
    
    @GetMapping
    public List<Response> getAllResponses() {
        return responseService.getAllResponses();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Response> getResponseById(@PathVariable Long id) {
        Optional<Response> response = responseService.getResponseById(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Response createResponse(@RequestBody Response response) {
        return responseService.createResponse(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateResponse(@PathVariable Long id, @RequestBody Response responseDetails) {
        try {
            Response updatedResponse = responseService.updateResponse(id, responseDetails);
            return ResponseEntity.ok(updatedResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Long id) {
        try {
            responseService.deleteResponse(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}