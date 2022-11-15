package com.xymiao.tutorial.mybatis.resource.mapper;

import com.xymiao.tutorial.mybatis.resource.pojo.SysRole;
import org.apache.ibatis.annotations.Select;

public interface SysRoleMapper {
    @Select("select role_id, role_name, valid_flag from sys_role where role_id = #{roleId}")
    SysRole getRoleInfo(String roleId);

    SysRole getRoleInfo2(String roleId);
}
