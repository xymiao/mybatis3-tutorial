package com.xymiao.tutorial.mybatis.mapper;

import com.xymiao.tutorial.mybatis.pojo.UserInfo;

public interface UserInfoMapper {
    /**
     * 正常的调用方式，驼峰属性配置
     * @param id 主键
     * @return 结果
     */
    UserInfo getUserInfo(int id);

    /**
     * 使用 sql 的别名方式进行和对象属性映射
     * @param id 主键
     * @return 结果
     */
    UserInfo getUserInfoByDb(int id);
}
