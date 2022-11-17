package com.mysite.nexfilx.User.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

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

    @Column(columnDefinition = "tinyint(1)", nullable = false)
    private Boolean auth;

    @Column
    private Date lastPaymentDate;

}
