package com.mysite.nexfilx.Contents.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NetflixDetailDto {
    private Long id;


    private String contentNum;
    private int detailepisode;

    private int playtime;

    private String subStory;

    private String subImg;
}
