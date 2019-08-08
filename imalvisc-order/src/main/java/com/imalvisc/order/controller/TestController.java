package com.imalvisc.order.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ApiOperation(value = "乐达", notes = "乐达")
    @GetMapping(value = "/loda")
    public JSONObject loda(String target) {
        String url = "https://www.loda.com.kh/Ajax/GetGrabGoods.ashx";
        //创建Spring自带的Http请求模板类
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(300000);
        requestFactory.setReadTimeout(300000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/x-www-form-urlencoded;charset=UTF-8");
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        headers.add("Connection", "keep-alive");
        headers.add("Host", "www.loda.com.kh");
        headers.add("Cookie", LodaLoginProcessor.login());

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("ResponseUrl", target);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
        //获取响应内容，并通过Jsoup解析问Document文档
        Document document = Jsoup.parseBodyFragment(responseEntity.getBody());
        //商品编号
        String prodNum = document.getElementById("goodsSkuMap").attr("data-GoodsId");
        System.out.println("商品编号：" + prodNum);
        //商品标题
        String prodName = document.getElementById("goodsSkuMap").attr("data-GoodsName");
        System.out.println("商品标题：" + prodName);
        //商品价格
        String prodPrice = document.getElementById("goodsSkuMap").attr("data-RMBprice");
        //判断价格是否为范围价格，是则截取最小部分
        if (StringUtils.isNotBlank(prodPrice) && prodPrice.indexOf("-") > 0) {
            prodPrice = prodPrice.split("-")[0];
        }
        System.out.println("商品价格：" + prodPrice);
        //店铺名称
        String storeName = document.getElementById("goodsSkuMap").attr("data-ShopName");
        System.out.println("店铺名称：" + storeName);
        //缩略图
        List<String> thumbImgList = new ArrayList<>();
        thumbImgList.add(document.getElementsByClass("jqzoom").get(0).attr("src"));
        System.out.println("缩略图：" + thumbImgList);
        //sku
        List<Element> skuNameEles = document.getElementsByClass("goodsSkuName");

        GoodsInfo goodsInfo = new GoodsInfo()
                .setGoodsPrice(Double.valueOf(prodPrice))
                .setHotStatus(GoodsInfo.HotStatus.NO)
                .setOnlineStatus(GoodsInfo.OnlineStatus.ONLINE)
                .setSales(0)
                .setShowImg((thumbImgList != null && thumbImgList.size() > 0)
                        ? thumbImgList.get(0).replace("60x60", "400x400") : null)
                .setTitleZh(prodName)
                .setGoodsNum(StringUtils.isNotBlank(prodNum) ? prodNum : "123456")
                .setStoreNameZh(storeName)
                .setGoodsSign(2)
                .setPublishTime(DateUtil.date());
        System.out.println("商品信息：" + goodsInfo);
        List<Map<String, Object>> goodsAttrs = new ArrayList<>();
        if (skuNameEles != null && skuNameEles.size() > 0) {
            Map<String, Object> goodsAttr;
            Map<String, String> attrValue;
            Element skuValueWrapEle;
            List<Element> skuValueEles;
            List<Element> skuValueImgEle;
            String skuName;
            for (Element skuNameEle : skuNameEles) {
                skuName = skuNameEle.text().replace(":", "");
                skuValueWrapEle = skuNameEle.nextElementSibling();
                skuValueEles = skuValueWrapEle.getElementsByClass("GoodsSKuImg");
                //普通文本属性
                if (skuValueEles == null || skuValueEles.size() <= 0) {
                    skuValueEles = skuValueWrapEle.getElementsByClass("goodsSkuTextAll");
                    for (Element skuValueEle : skuValueEles) {
                        goodsAttr = new HashMap<>();
                        goodsAttr.put("attrKey", skuName);
                        attrValue = new HashMap<>();
                        attrValue.put("title", skuValueEle.text());
                        goodsAttr.put("attrValue", attrValue);
                        goodsAttrs.add(goodsAttr);
                    }
                } else { //图片属性
                    skuValueEles = skuValueWrapEle.getElementsByClass("goodsSkuTextAll");
                    for (Element skuValueEle : skuValueEles) {
                        skuValueImgEle = skuValueEle.getElementsByClass("GoodsSKuImg");
                        thumbImgList.add(skuValueImgEle.get(0).attr("src"));
                        goodsAttr = new HashMap<>();
                        goodsAttr.put("attrKey", skuName);
                        attrValue = new HashMap<>();
                        attrValue.put("title", skuValueImgEle.get(0).attr("title"));
                        attrValue.put("img", skuValueImgEle.get(0).attr("src"));
                        goodsAttr.put("attrValue", attrValue);
                        goodsAttrs.add(goodsAttr);
                    }
                }
            }
        }
        System.out.println("属性：" + goodsAttrs);
        System.out.println("图片：" + thumbImgList);
        //爬取结果id
        return null;
    }

}
