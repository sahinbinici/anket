package com.anket.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "options")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String text;
    
    @Column(name = "display_order")
    private int displayOrder;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
    
    @OneToMany(mappedBy = "selectedOption", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;
}