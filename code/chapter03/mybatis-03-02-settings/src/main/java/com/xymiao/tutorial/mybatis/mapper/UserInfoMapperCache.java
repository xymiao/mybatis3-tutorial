package com.xymiao.tutorial.mybatis.mapper;

import com.xymiao.tutorial.mybatis.pojo.UserInfo;

public interface UserInfoMapperCache {
    /**
     * 正常的调用方式，驼峰属性配置
     * @param id 主键
     * @return 结果
     */
    UserInfo getUserInfo(int id);
}

