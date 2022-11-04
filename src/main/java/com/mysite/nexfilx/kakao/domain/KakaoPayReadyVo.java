package com.mysite.nexfilx.kakao.domain;

import lombok.Data;

@Data
public class KakaoPayReadyVo {
    private String tid, next_redirect_pc_url;
    private Data created_at;
}
