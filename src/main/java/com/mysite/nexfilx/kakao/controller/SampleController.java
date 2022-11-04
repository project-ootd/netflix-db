package com.mysite.nexfilx.kakao.controller;

import com.mysite.nexfilx.kakao.service.KakaoPay;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URL;

@Log
@Controller
//@RequestMapping("kakao")
public class SampleController {

    @Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;


    @GetMapping("/test")
    public String test1() {
        return "testPage";
    }


    @GetMapping("/kakaoPay")
    public void kakaoPayGet() {

    }

    @PostMapping("/kakaoPay")
    public String kakaoPay() {
        log.info("kakaoPay post............................................");

        return "redirect:" + kakaopay.kakaoPayReady();

    }

    @GetMapping("/kakaoPaySuccess")
    public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);

    }


    @GetMapping("/kakaoPayCancel")
    public void kakaoPayCancel() {
        log.info("kakaoPayCancel get............................................");

    }

    @GetMapping("/kakaoPaySuccessFail")
    public void kakaoPaySuccessFail() {
        log.info("kakaoPaySuccessFail get............................................");

    }


}
