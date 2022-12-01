package com.mysite.nexfilx.Contents.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NetflixContents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String contentNum;

    @Column(unique = true)
    private String contentId;

    @Column
    private String contentName;
    private int episodes;
    private String date;
    private String actor;
    private int age;
    private String director;


    @Lob
    private String contentImg;
    @Lob
    private String rankingImg;
    @Lob
    private String contentVideo;
    @Lob
    private String detailImg;
    @Lob
    private String detailTextImg;

    private String mainStory;


}
