package com.anket.services;

import com.anket.entities.Option;
import com.anket.entities.Question;
import com.anket.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OptionService {
    
    @Autowired
    private OptionRepository optionRepository;
    
    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }
    
    public List<Option> getOptionsByQuestion(Question question) {
        return optionRepository.findByQuestion(question);
    }
    
    public Optional<Option> getOptionById(Long id) {
        return optionRepository.findById(id);
    }
    
    public Option createOption(Option option) {
        return optionRepository.save(option);
    }
    
    public Option updateOption(Long id, Option optionDetails) {
        Option option = optionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Option not found with id: " + id));
        
        option.setText(optionDetails.getText());
        option.setDisplayOrder(optionDetails.getDisplayOrder());
        
        return optionRepository.save(option);
    }
    
    public void deleteOption(Long id) {
        Option option = optionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Option not found with id: " + id));
        optionRepository.delete(option);
    }
}