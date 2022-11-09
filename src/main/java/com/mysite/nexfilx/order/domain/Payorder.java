package com.mysite.nexfilx.order.domain;

import lombok.*;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Payorder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long orderId;

    @Column(unique = true)
    private String orderNum;

    @Column(nullable = false)
    private String useremail;

    private Date orderDate;

}
