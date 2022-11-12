package com.xymiao.tutorial.mybatis.mapper;

import com.xymiao.tutorial.mybatis.pojo.UserInfo;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

@CacheNamespace
public interface UserInfoMapperAnnotation {
    /**
     * 正常的调用方式，驼峰属性配置
     * @param id 主键
     * @return 结果
     */

    @Select("select id, real_name, nick_name, age, role_id from user_info where id = #{id}")
    UserInfo getUserInfo(int id);
}

