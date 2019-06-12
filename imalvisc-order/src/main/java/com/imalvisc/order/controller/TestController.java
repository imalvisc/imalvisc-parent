package com.imalvisc.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName TestController
 * @Description TODO
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-12 10:52
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Api(value = "测试", tags = "测试")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "爬虫", notes = "爬虫")
    @GetMapping(value = "/magic")
    public String magic() {
        String indexSource = restTemplate.getForObject("http://www.univ-bio.com/", String.class);
        Document document = Jsoup.parseBodyFragment(indexSource);
        Element kangti = document.getElementsByClass("subitem").get(0);
        List<Element> dls = kangti.getElementsByTag("dl");
        for (Element dl : dls) {
            Element dd = dl.getElementsByTag("dd").get(0);
            List<Element> subs = dd.getElementsByTag("a");
            for (int i = 0; i < subs.size(); i++) {
                Element sub = subs.get(i);
                String text = sub.text();
                String detailUrl = sub.attr("href");
                if (i == 0) {
                    System.out.println(text);
                    String detailSource = restTemplate.getForObject("http://www.univ-bio.com/" + detailUrl, String.class);
                    System.out.println(detailSource);
                }
            }
        }
        return "成功";
    }

}
