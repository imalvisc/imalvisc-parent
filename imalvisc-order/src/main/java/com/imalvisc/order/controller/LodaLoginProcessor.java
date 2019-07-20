package com.imalvisc.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LodaLoginProcessor
 * @Model 爬虫管理
 * @Description Loda登录处理
 * @Author imalvisc
 * @Sign 学会编程，而不是学会编码！
 * @Date 2019-01-11 9:01
 * @Email 13570038865@163.com
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@Slf4j
public class LodaLoginProcessor {

    private static final String URL = "https://www.loda.com.kh/user/Ajax/UserLogin.ashx";

    private static final String URL1 = "https://www.loda.com.kh/Grabgoods.aspx?url=https://detail.1688.com/offer/565350991873.html?spm=a262eq.12572822.jspytrj4.1.39c03d3a9CMoaA";

    /**
     * 执行模拟登录
     *
     * @return
     */
    public static String login() {
        //创建Spring自带的Http请求模板类
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(300000);
        requestFactory.setReadTimeout(300000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        headers.add("Connection", "keep-alive");
        headers.add("Host", "www.loda.com.kh");
        headers.add("Cookie", "CookiesLanguage=CN");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("loginName", "Kuysovann1688@gmail.com");
        params.add("hfPwd", "fb98262dd30a299b5cd39cdb73e5a26a");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行Http请求
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class, params);
        System.out.println(responseEntity.getHeaders());
        return parseCookie(responseEntity.getHeaders());
    }

    /**
     * 解析登录后的cookie信息
     *
     * @param httpHeaders
     * @return
     */
    private static String parseCookie(HttpHeaders httpHeaders) {
        String result = "";
        List<String> cookieList = httpHeaders.get("Set-Cookie");
        Map<String, String> cookieMap = null;
        if (cookieList != null && cookieList.size() > 0) {
            cookieMap = new HashMap<>();
            String[] arr;
            String[] item;
            for (String cookie : cookieList) {
                arr = cookie.split(";");
                if (arr != null && arr.length > 0) {
                    for (String s : arr) {
                        item = s.split("=");
                        if (item.length > 1) {
                            cookieMap.put(item[0], item[1]);
                        }
                    }
                }
            }
        }
        if (cookieMap != null) {
            result = "ASP.NET_SessionId=" + cookieMap.get("ASP.NET_SessionId") + "; SID=" + cookieMap.get("SID") + "; CookiesLanguage=CN";
        }
        return result;
    }

    public static void main(String[] args) {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Cookie", "CookiesLanguage=CN; ASP.NET_SessionId=ifox1lutajw451zkqs54uqso;SID=045d4c3c-62d2-47be-bc70-4c0d89328556;");
//        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
//        //执行Http请求
//        ResponseEntity<String> responseEntity = restTemplate.exchange(URL1, HttpMethod.GET, requestEntity, String.class);
//        System.out.println(responseEntity.getBody());
        System.out.println(login());
    }

}
