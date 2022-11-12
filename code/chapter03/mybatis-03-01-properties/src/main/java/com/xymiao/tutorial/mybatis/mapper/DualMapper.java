package com.xymiao.tutorial.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

public interface DualMapper {
    @Select(value = "select NOW() from dual")
    String getCurrDate();
}
