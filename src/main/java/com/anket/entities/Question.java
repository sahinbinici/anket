package com.anket.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String text;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuestionType type;
    
    @Column(name = "is_required")
    private boolean isRequired;
    
    @Column(name = "display_order")
    private int displayOrder;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;
    
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Option> options;
    
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;
    
    public enum QuestionType {
        MULTIPLE_CHOICE, TEXT
    }
}