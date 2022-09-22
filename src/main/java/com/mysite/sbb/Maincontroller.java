package com.mysite.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.mysite.sbb.question.dao.QuestionRepository;
import com.mysite.sbb.question.doamin.Question;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class Maincontroller {
    int sum=0;
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping("/sbb")
    @ResponseBody
    public String index(){
        System.out.println("main");
        return "sbb!!";
    }
//    @GetMapping("/page1")
//    @ResponseBody
//    public String showPage(){
//
//        return """
//                <form method="POST" action="/plus">
//                <input type='number' name="first" placeholder="첫번째 숫자"/>
//                <input type='number' name="second" placeholder="두번째 숫자"/>
//                <input type='submit' value="plus"/>
//
//                <from/>
//                <form method="POST" action="/minus">
//                <input type='number' name="first" placeholder="첫번째 숫자"/>
//                <input type='number' name="second" placeholder="두번째 숫자"/>
//                <input type='submit' value="minus"/>
//                <form/>
//                <form method="POST" action="/increase">
//                <input type='submit' value="increase"/>
//                <from/>
//                """ ;
//
//    }
    @GetMapping("/plus")
    @ResponseBody
    public int plus(@RequestParam (value = "a", defaultValue ="0")int a,
    @RequestParam(value ="b", defaultValue = "0")int b){
        return a+b;
    }
    @GetMapping("/minus")
    @ResponseBody
    public int minus(@RequestParam (value = "a", defaultValue ="0")int a,
                                @RequestParam(value ="b", defaultValue = "0")int b){
        return a-b;
    }
    @GetMapping("/increase")
    @ResponseBody
    public int increase(){
        sum++;
        return sum;
    }


    @GetMapping("/gugudan")
    @ResponseBody
    public String gugudan( int dan, int limit){
        System.out.println("구구단 출력");
        String sub="";
        for(int i=1;i<=limit;i++){
            sub += dan+" * "+ i +" = "+(dan * i)+"<br/>\n";
        }
        return sub;
    }

    @GetMapping("/saveSessionAge")
    @ResponseBody
    public String saveSession(@RequestParam("age")int age, HttpSession session){
        session.setAttribute("age",age);
        return "나이 세션에 저장된 나이는 "+age+"입니다.";
    }

    @GetMapping("/getSessionAge")
    @ResponseBody
    public String getSession(HttpSession session, HttpServletResponse res){
        int age = (int)session.getAttribute("age");
        Cookie cookie = new Cookie("age",String.valueOf(age));
        res.addCookie(cookie);
        return "나이는 "+age+" 살 입니다.";
    }
    @GetMapping("/myPage")
    @ResponseBody
    public String mypage(){
        String sum="";
        for(int i = 1; i<=9;i++){
            for(int j= 1; j<=9;j++){

                sum += i+" * "+ j + " = " + i*j +"<br/>\n";
            }
        }
        return sum;
    }

    @GetMapping("/addperson/{id}/{age}")
    @ResponseBody
    public Person addPerson(Person person, @PathVariable("id")Integer id, @PathVariable("age") Integer age){
    return person;
    }
    @Getter
    @AllArgsConstructor
    class Person{
        private int id;
        private int age;
        private String name;


    }
    @GetMapping("/createQuestion")
    @ResponseBody
    public List<Question> createQuestion() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);  // 첫번째 질문 저장

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);  // 두번째 질문 저장

        return questionRepository.findAll();
    }

}
