package com.anket.repositories;

import com.anket.entities.Option;
import com.anket.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByQuestion(Question question);
}