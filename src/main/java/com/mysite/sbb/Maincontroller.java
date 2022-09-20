package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Maincontroller {
    @RequestMapping("/sbb")
    @ResponseBody
    public String index(){
        System.out.println("main");
        return "sbb!!";
    }
    @GetMapping("/page1")
    @ResponseBody
    public String showPage(){

        return """
                <form method="POST" action="/page2">
                <input type='number' name="age" placeholder="나이"/>
                <input type='submit' value="page2로 POST 방식으로 이동"
                <from/>
                """ ;
    }
    @PostMapping("page2")
    @ResponseBody
    public String showPage2Post(@RequestParam (value = "age", defaultValue ="0")int age ){
        return """
                <h1> 입력된 나이 : %d<h1/>
                <h1> POST 방식으로 옴<h1/>
                """.formatted(age);
    }
    @GetMapping("/page2")
    @ResponseBody
    public String showPage2Get(){
        return """
                <h1> 입력된 나이 : %d<h1/>
                <h1> GET 방식으로 옴<h1/>
                """;
    }

}
