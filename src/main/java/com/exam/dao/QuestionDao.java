package com.exam.dao;

import com.exam.entities.exam.Question;
import com.exam.entities.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionDao extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
