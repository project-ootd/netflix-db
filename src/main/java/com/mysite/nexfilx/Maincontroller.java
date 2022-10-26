package com.mysite.nexfilx;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Maincontroller {
    @RequestMapping("/login")
    @ResponseBody
    public String login(){
        String al = "넷플릭스 로그인 페이지";
        return al;
    }
}
