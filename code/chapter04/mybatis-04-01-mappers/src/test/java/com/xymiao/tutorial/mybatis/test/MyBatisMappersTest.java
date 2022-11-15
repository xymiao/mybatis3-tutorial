package com.xymiao.tutorial.mybatis.test;

import com.xymiao.tutorial.mybatis.resource.mapper.SysResMapper;
import com.xymiao.tutorial.mybatis.resource.mapper.SysRoleMapper;
import com.xymiao.tutorial.mybatis.resource.pojo.SysRes;
import com.xymiao.tutorial.mybatis.resource.pojo.SysRole;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisMappersTest {
    private final static Logger logger = LoggerFactory.getLogger(MyBatisMappersTest.class);

    /**
     * resource 的引用方式
     * @throws IOException
     */
    @Test
    public void testMappersResource() throws IOException {
        String resource = "resource/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole roleInfo = sysRoleMapper.getRoleInfo("1");
            logger.info("roleInfo: {}", roleInfo);
            roleInfo = sysRoleMapper.getRoleInfo2("1");
            logger.info("roleInfo: {}", roleInfo);
            SysResMapper sysResMapper = sqlSession.getMapper(SysResMapper.class);
            List<SysRes> sysResList = sysResMapper.queryResListByRoleId(String.valueOf(roleInfo.getRoleId()));
            logger.info("res list: {}", sysResList);
        }
    }

}
