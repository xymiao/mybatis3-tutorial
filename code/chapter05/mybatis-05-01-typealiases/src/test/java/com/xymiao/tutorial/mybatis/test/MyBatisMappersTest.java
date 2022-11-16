package com.xymiao.tutorial.mybatis.test;

import com.xymiao.tutorial.mybatis.mapper.SysResMapper;
import com.xymiao.tutorial.mybatis.mapper.SysRoleMapper;
import com.xymiao.tutorial.mybatis.pojo.SysRes;
import com.xymiao.tutorial.mybatis.pojo.SysRole;
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
     * typeAliases
     *
     * @throws IOException 返回异常
     */
    @Test
    public void testTypeAliases() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole roleInfo = sysRoleMapper.getRoleInfo("1");
            logger.info("roleInfo: {}", roleInfo);

            SysResMapper sysResMapper = sqlSession.getMapper(SysResMapper.class);
            List<SysRes> resInfoList = sysResMapper.queryResListByRoleId(String.valueOf(roleInfo.getRoleId()));
            logger.info("roleRes: {}", resInfoList);

            resInfoList = sysResMapper.queryResListByValidFlag("1");
            logger.info("roleRes: {}", resInfoList);

        }
    }


    /**
     * typeAliases 的 package 方式
     *
     * @throws IOException 返回异常
     */
    @Test
    public void testTypeAliasesPackage() throws IOException {
        String resource = "mybatis-config-package.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            SysRoleMapper sysRoleMapper = sqlSession.getMapper(SysRoleMapper.class);
            SysRole roleInfo = sysRoleMapper.getRoleInfo("1");
            logger.info("roleInfo: {}", roleInfo);

            SysResMapper sysResMapper = sqlSession.getMapper(SysResMapper.class);
            List<SysRes> resInfoList = sysResMapper.queryResListByRoleId(String.valueOf(roleInfo.getRoleId()));
            logger.info("roleRes: {}", resInfoList);

            resInfoList = sysResMapper.queryResListByValidFlag("1");
            logger.info("roleRes: {}", resInfoList);
        }
    }

    @Test
    public void testSimpleName(){
        String simpleName = MyBatisMappersTest.class.getSimpleName();
        logger.info("MyBatisMappersTest 的 simpleName: {}", simpleName);
    }

}
