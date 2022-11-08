package com.mysite.nexfilx.User.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(unique = true,nullable = false)
    private String useremail;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "tinyint(1) default 0", nullable = false)
    private Boolean auth;


}
