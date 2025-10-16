package com.anket.repositories;

import com.anket.entities.Question;
import com.anket.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySurvey(Survey survey);
}