package com.mysite.nexfilx.Contents.service;

import com.mysite.nexfilx.Contents.dao.ContentRepository;
import com.mysite.nexfilx.Contents.domain.NetflixContentDetails;
import com.mysite.nexfilx.Contents.domain.NetflixContents;
import com.mysite.nexfilx.Contents.dto.NetflixDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContentService {
    private final ContentRepository contentRepository;



    public List<NetflixDto> getNetflixContentsByContentNum(String keyword) {
        return contentRepository.findByContentNumContaining(keyword).stream()
                .map(content -> {
                    NetflixDto netflixDto = new NetflixDto(content);
                    return netflixDto;
                })
                .toList();
    }

    public List<NetflixDto> getNetflixContentsBySearch(String keyword) {
        return contentRepository.findByContentNameContaining(keyword).stream()
                .map(content -> {
                    NetflixDto netflixDto = new NetflixDto(content);
                    return netflixDto;
                })
                .toList();
    }

    public List<NetflixContents> getNetflixContents() {
        return contentRepository.findAll();
    }

    public List<NetflixContentDetails> getNetflixContentDetail(String contentNum) {
        return contentRepository.findByContentNum(contentNum);
    }
}