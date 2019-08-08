package com.imalvisc.order.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @ClassName GoodsInfo
 * @Model 商品管理
 * @Description 商品信息Entity类，用于与数据表进行映射
 * @Author imalvisc
 * @Sign 学会编程，而不是学会编码！
 * @Date 2018/11/28 9:55
 * @Email 13570038865@163.com
 * @Copyright Guangzhou micro pole mobile Internet Technology Co., Ltd.
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class GoodsInfo {

    public class HotStatus {
        public static final int NO = 0;
        public static final int YSE = 1;
    }

    public class OnlineStatus {
        public static final int OFFLINE = 0;
        public static final int ONLINE = 1;
    }

    public class GoodsSign {
        public static final int SELF = 1;
        public static final int ALIBABA = 2;
        public static final int TAOBAO = 3;
        public static final int TMALL = 4;
        public static final int JD = 5;
    }

    public class DelStatus {
        public static final int YES = 0;
        public static final int NO = 1;
    }

    private Integer id;

    private String goodsNum;

    private String titleZh;

    private String titleEn;

    private String titleKm;

    private Integer storeId;

    private String storeNameZh;

    private String storeNameEn;

    private String storeNameKm;

    private String columnId;

    private Integer firTypeId;

    private Integer seTypeId;

    private Integer thTypeId;

    private Integer hotStatus = HotStatus.YSE;

    private Double goodsPrice;

    private Integer goodsSign = GoodsSign.SELF;

    private String showImg;

    private Integer sales = 0;

    private Integer onlineStatus = OnlineStatus.ONLINE;

    private Integer delStatus = DelStatus.NO;

    private Date publishTime;


}
