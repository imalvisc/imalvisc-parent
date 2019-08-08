package com.imalvisc.user.core;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName IMapper
 * @Description 通用Mapper接口，基于tkmapper
 * @motto 学会编程而不是学会编码！
 * @date 2019-06-12 14:32
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@RegisterMapper
public interface IMapper<T> extends Mapper<T>, ConditionMapper<T>, IdsMapper<T>, MySqlMapper<T> {

}
