package com.anket.repositories;

import com.anket.entities.Survey;
import com.anket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> findByCreator(User creator);
    List<Survey> findByIsActiveTrue();
}