package com.anket.repositories;

import com.anket.entities.Answer;
import com.anket.entities.Question;
import com.anket.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);
    List<Answer> findByResponse(Response response);
}