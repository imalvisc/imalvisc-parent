package com.imalvisc.user.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imalvisc.user.model.dto.PageDTO;
import com.imalvisc.user.model.vo.PageVO;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName PageUtils
 * @Description 分页工具类
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 14:02
 */
public class PageUtils {

    /**
     * 转换IPage
     *
     * @param pageDTO
     * @param type
     * @param <T>
     * @return
     */
    public static <T> IPage<T> toPage(PageDTO pageDTO, @SuppressWarnings("unused") Class<T> type) {
        IPage<T> page = new Page<>();
        page.setCurrent(pageDTO.getCurrent());
        page.setSize(pageDTO.getSize());
        return page;
    }

    /**
     * 解析为IPage
     *
     * @param iPage
     * @param <T>
     * @return
     */
    public static <T> PageVO<T> parsePage(IPage<T> iPage) {
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setTotal(iPage.getTotal());
        pageVO.setRecords(iPage.getRecords());
        return pageVO;
    }

}
