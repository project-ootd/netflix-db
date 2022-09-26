package com.mysite.sbb;


import com.mysite.sbb.answer.dao.AnswerRepository;
import com.mysite.sbb.answer.domain.Answer;
import com.mysite.sbb.question.dao.QuestionRepository;
import com.mysite.sbb.question.doamin.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;



//	@Test
//	void contextLoads() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		questionRepository.save(q1);
//
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
//	}
//
//	@Test
//	void getQuestions() {
//		List<Question> all = questionRepository.findAll();
//		assertEquals(4, all.size());
//
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//
//	}
//
//	@Test
//	void getQuestionById() {
//		Optional<Question> oq = questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}
//	}
//
//	@Test
//	void getQuestionBySubject() {
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q.getId());
//	}

//	@Test
//	void getQuestionsBySubject() {
//		List<Question> questions = this.questionRepository.findAllBySubject("sbb가 무엇인가요?");
//		assertEquals(2, questions.size());
//	}

//	@Test
//	void getQuestionsByTwoSubjects() {
//		List<String> searchWordList = new ArrayList<>();
//		searchWordList.add("sbb가 무엇인가요?");
//		searchWordList.add("스프링부트 모델 질문입니다.");
//
//		List<Question> questions = this.questionRepository.findAllBySubjectIn(searchWordList);
//		assertEquals(4, questions.size());
//}

	@Test
	void getQuestionsBySubjectAndContent() {
		List<Question> questions = questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
		assertEquals(1, questions.size());
	}

	@Test
	void getQuestionHaveStrings(){
		List<Question> questions = questionRepository.findBySubjectLike("sbb%");
		assertEquals(1,questions.size());
	}

	@Test
	void updateQuestion() {
		Optional<Question> oq = questionRepository.findById(3);
		if(oq.isPresent()) {
			Question question = oq.get();
			question.setSubject("스프링 부트가 너무 어려워요");
			question.setContent("스프링 부트가 너무 어려운데 천천히 공부 할 수 있는 사이트나 책이 있을까요?");
			questionRepository.save(question);
		}
	}
	@Test
	void deleteQuestion() {
		assertEquals(2, questionRepository.count());
		Optional<Question> oq = questionRepository.findById(1);
		if(oq.isPresent()) {
			Question question = oq.get();
			questionRepository.delete(question);
		}
		assertEquals(2, questionRepository.count());
	}


	@Test
	void createAnswer() {
		Optional<Question> oq = questionRepository.findById(3);
		if(oq.isPresent()){
			Question question = oq.get();

			Answer answer = new Answer();
			answer.setContent("점프 투 스프링 부트 사이트에 접속해서 하나하나 해보는 것을 추천드려요");
			answer.setQuestion(question);
			answer.setCreateDate(LocalDateTime.now());
			answerRepository.save(answer);

		}

	}

	@Test
	void getAnswersByQuestion(){
		Optional<Question> oq = questionRepository.findById(3);
		if(oq.isPresent()){
			Question question = oq.get();
			List<Answer> answerList = question.getAnswerList();
			assertEquals(1,answerList.size());
		}
	}
	@Test
	void contextLoads() {
		Question q3 = new Question();
		q3.setSubject("스프링 공부는 어떻게 하는게 좋을까요?");
		q3.setContent("스프링에 관련해서 처음 배워보는데 추천하시는 사이트나 책이 있나요?");
		q3.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q3);  // 첫번째 질문 저장

		Question q4 = new Question();
		q4.setSubject("스프링부트를 쉽게 배우는 방법이 있나요?");
		q4.setContent("스프링부트를 쉽게 배우는 방법이 있다면 알려주세요");
		q4.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q4);  // 두번째 질문 저장
	}
}

