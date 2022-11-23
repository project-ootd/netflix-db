package com.mysite.nexfilx.Contents.controller;

import com.mysite.nexfilx.Contents.dao.ContentRepository;
import com.mysite.nexfilx.Contents.domain.NetflixContentDetails;
import com.mysite.nexfilx.Contents.domain.NetflixContents;
import com.mysite.nexfilx.Contents.dto.NetflixDetailDto;
import com.mysite.nexfilx.Contents.dto.NetflixDto;
import com.mysite.nexfilx.Contents.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class ContentController {
    @Autowired
    private final ContentService contentService;

    private final ContentRepository contentRepository;

    @GetMapping("/contents")
    public List<NetflixDto> getAllContents(@RequestParam("kw") String keyword) {
        return contentService.getNetflixContentsByContentNum(keyword);
    }

    @GetMapping("/search/{sk}")
    public List<NetflixDto> getKeywords(@PathVariable() String sk) {

        return contentService.getNetflixContentsBySearch(sk);
    }

    @GetMapping("/allcontent")
    public List<NetflixDto> getNetflixContents() {
        return contentService.getNetflixContent();
    }

    @GetMapping("/rank")
    public List<NetflixDto> getRankItems() {
        return  contentService.getNetflixContentsByContentNum("KR-RANK");
    }


}