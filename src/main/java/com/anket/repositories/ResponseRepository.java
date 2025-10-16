package com.anket.repositories;

import com.anket.entities.Response;
import com.anket.entities.Survey;
import com.anket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> findBySurvey(Survey survey);
    List<Response> findByRespondent(User respondent);
    List<Response> findBySurveyAndRespondent(Survey survey, User respondent);
}