package com.mysite.nexfilx.Contents.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NetflixContentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;


    private String contentNum;
    private int detailepisode;

    @Column
    private int playtime;

    @Lob
    private String subStory;

    @Lob
    private String subImg;



}





