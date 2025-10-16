package com.anket.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "responses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User respondent;
    
    @OneToMany(mappedBy = "response", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;
}