package com.xymiao.tutorial.mybatis.mapper;

import com.xymiao.tutorial.mybatis.pojo.Hello;

public interface HelloMapper {
    /**
     * 获得 Hello 对象
     * @param id  主键
     * @return Hello 的对象信息
     */
    Hello getHelloInfo(int id);
}
