package com.anket.controllers;

import com.anket.entities.Option;
import com.anket.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/options")
@CrossOrigin(origins = "*")
public class OptionController {
    
    @Autowired
    private OptionService optionService;
    
    @GetMapping
    public List<Option> getAllOptions() {
        return optionService.getAllOptions();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Option> getOptionById(@PathVariable Long id) {
        Optional<Option> option = optionService.getOptionById(id);
        if (option.isPresent()) {
            return ResponseEntity.ok(option.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Option createOption(@RequestBody Option option) {
        return optionService.createOption(option);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Option> updateOption(@PathVariable Long id, @RequestBody Option optionDetails) {
        try {
            Option updatedOption = optionService.updateOption(id, optionDetails);
            return ResponseEntity.ok(updatedOption);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable Long id) {
        try {
            optionService.deleteOption(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}