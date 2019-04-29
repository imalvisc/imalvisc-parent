package com.imalvisc.user.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName PageVO
 * @Description 分页VO
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 14:15
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageVO<T> {

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 列表数据
     */
    private List<T> records;

}
