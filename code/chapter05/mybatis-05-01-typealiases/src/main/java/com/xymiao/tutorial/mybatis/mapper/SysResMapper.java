package com.xymiao.tutorial.mybatis.mapper;

import com.xymiao.tutorial.mybatis.pojo.SysRes;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysResMapper {
    @Select("select res_id, role_id, res_name, res_url, valid_flag " +
            " from sys_res where role_id in ( select role_id from sys_role where role_id = #{roleId} )")
    List<SysRes> queryResListByRoleId(String roleId);

    List<SysRes> queryResListByValidFlag(String validFlag);
}
