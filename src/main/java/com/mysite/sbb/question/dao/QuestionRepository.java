package com.mysite.sbb.question.dao;

import com.mysite.sbb.question.doamin.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
//     Question findBySubject(String s);
//
//
//
//
//     List<Question> findAllBySubjectIn(List<String> searchWordList);
//
//     List<Question> findAllBySubject(String s);



     List<Question> findBySubjectAndContent(String Subject, String Content);

     List<Question> findBySubjectLike(String searchString);
}