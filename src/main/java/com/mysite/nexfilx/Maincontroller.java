package com.mysite.nexfilx;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Setter
@Getter
@Controller
public class Maincontroller {
    @RequestMapping("/netflix")
    @ResponseBody
    public String test(){
        return "어서오세요 넷플릭스 입니다.";
    }
}
