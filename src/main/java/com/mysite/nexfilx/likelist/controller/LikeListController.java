package com.mysite.nexfilx.likelist.controller;

import com.mysite.nexfilx.Contents.domain.NetflixContents;
import com.mysite.nexfilx.likelist.service.LikeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LikeListController {
    @Autowired
    private LikeListService likeListService;

    @PostMapping("/browse/my-list")
    public boolean postlike(@RequestParam String useremail, @RequestParam Long contentId) {
        System.out.println("email : "+ useremail+"\n"+"contentId : "+contentId);
        return likeListService.list(useremail,contentId);
    }

    @GetMapping("/browse/my-list")
    public List<NetflixContents> getlike(@RequestParam String useremail){
        System.out.println("확인 : "+useremail);
        return likeListService.checklist(useremail);
    }


//    @GetMapping("/browse/my-list/check/{useremail}")
//    public boolean getchecklike(@PathVariable String useremail){
//        System.out.println("이메일 : "+useremail);
//        return likeListService.checkicon(useremail);
//    }


}

