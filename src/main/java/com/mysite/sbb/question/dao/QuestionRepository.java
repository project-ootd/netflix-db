package com.mysite.sbb.question.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mysite.sbb.question.doamin.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}