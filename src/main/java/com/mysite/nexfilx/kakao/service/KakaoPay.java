package com.mysite.nexfilx.kakao.service;

import com.mysite.nexfilx.kakao.ReadyResponse;
import com.mysite.nexfilx.kakao.domain.ReadyResponseVO;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
//@Log
@Slf4j
public class KakaoPay {

    private static final String HOST = "https://kapi.kakao.com";
        private ReadyResponseVO readyResponseVO;

    public String payReady() {


        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "bcbc527b40a4074841e8ef3f491cf2e6");
        headers.add("Accept",   MediaType.APPLICATION_JSON_VALUE);
        headers.add("Content-Type", org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME"); // 가맹정 코드 (test는 카카오에서 제공하는 샘플 코드 사용)
        params.add("partner_order_id", "1001"); // 주문 번호
        params.add("partner_user_id", "gorany"); // 주문자명
        params.add("item_name", "TICKET"); // 상품 이름
        params.add("quantity", "1"); // 상품 수량
        params.add("total_amount", "10000"); // 결제 금액
        params.add("tax_free_amount", "0");
        params.add("approval_url", "http://localhost:8084/kakaoPaySuccess"); //결제 완료 시 이동 페이지
        params.add("cancel_url", "http://localhost:8084/kakaoPayCancel"); // 결제 취소 시 이동 페이지
        params.add("fail_url", "http://localhost:8084/kakaoPaySuccessFail");

        HttpEntity<MultiValueMap<String,String>> body = new HttpEntity<MultiValueMap<String , String>>(params, headers);

        try {
            readyResponseVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, ReadyResponseVO.class);
            log.info("" + readyResponseVO);

            return readyResponseVO.getNext_redirect_pc_url();
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return "kakao";

//        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
//        parameters.add("cid", "TC0ONETIME");
//        parameters.add("partner_order_id", "1010");
//        parameters.add("partner_user_id", "testUserId");
//        parameters.add("item_name", "testIten");
//        parameters.add("quantity", "1");
//        parameters.add("total_amount", "2000");
//        parameters.add("tax_free_amount", "0");
//        parameters.add("approval_url", "http://localhost:8084/kakaoPaySuccess"); // 결제승인시 넘어갈 url
//        parameters.add("cancel_url", "http://localhost:8084/kakaoPayCancel"); // 결제취소시 넘어갈 url
//        parameters.add("fail_url", "http://localhost:8084/kakaoPaySuccessFail"); // 결제 실패시 넘어갈 url
//
//        log.info("파트너주문아이디:"+ parameters.get("partner_order_id")) ;
//
//        HttpEntity<MultiValueMap<String , String>> requrstEntity =
//                new HttpEntity<>(parameters, this.getHeaders());
//
//
////        try {
//
////            RestTemplate restTemplate = new RestTemplate();
////            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//        RestTemplate template = new RestTemplate();
//            String url = "https://kapi.kakao.com/v1/payment/ready";
//
//            ReadyResponse readyResponse = template.postForObject(url, requrstEntity, ReadyResponse.class);
//            log.info("결제준비 응답객체");
//
//            return readyResponse;
//
//        } catch (RestClientException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//
//        return null;
    }

//    private HttpHeaders getHeaders() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "bcbc527b40a4074841e8ef3f491cf2e6");
//        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//
//        return headers;
//    }
}
