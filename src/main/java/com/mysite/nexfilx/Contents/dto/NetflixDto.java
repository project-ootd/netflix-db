package com.mysite.nexfilx.Contents.dto;

import com.mysite.nexfilx.Contents.domain.NetflixContents;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NetflixDto {

    private Long id;


    private String contentNum;

    private String contentId;
    private String contentName;
    private int episodes;
    private String date;
    private String actor;
    private int age;
    private String director;


    private String contentImg;

    private String rankingImg;
    private String contentVideo;

    private String detailImg;

    private String detailTextImg;

    private String mainStory;


    public NetflixDto(NetflixContents netflixContents) {
        id = netflixContents.getId();
        contentNum = netflixContents.getContentNum();
        contentName = netflixContents.getContentName();
        episodes = netflixContents.getEpisodes();
        date = netflixContents.getDate();
        actor = netflixContents.getActor();
        age = netflixContents.getAge();
        director = netflixContents.getDirector();
        contentImg = netflixContents.getContentImg();
        rankingImg = netflixContents.getRankingImg();
        contentVideo = netflixContents.getContentVideo();
        detailImg = netflixContents.getDetailImg();
        detailTextImg = netflixContents.getDetailTextImg();
        mainStory = netflixContents.getMainStory();
    }
}