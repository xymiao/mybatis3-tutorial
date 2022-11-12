package com.xymiao.tutorial.mybatis.test;

import com.xymiao.tutorial.mybatis.mapper.UserInfoMapper;
import com.xymiao.tutorial.mybatis.mapper.UserInfoMapperAnnotation;
import com.xymiao.tutorial.mybatis.mapper.UserInfoMapperCache;
import com.xymiao.tutorial.mybatis.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 缓存相关的演示
 */
public class MyBatisSettingsCacheTest {
    /**
     * 缓存开启演示案例
     * @throws IOException 抛出异常
     */
    @Test
    public void settingCacheEnabled () throws IOException {
        String resource = "mybatis-config-cache-enabled.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserInfoMapperCache mapper = sqlSession.getMapper(UserInfoMapperCache.class);
            UserInfo userInfo = mapper.getUserInfo(1);
            System.out.println(userInfo);
        }
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserInfoMapperCache mapper = sqlSession.getMapper(UserInfoMapperCache.class);
            UserInfo userInfo = mapper.getUserInfo(1);
            System.out.println(userInfo);
        }
    }

    /**
     * 缓存关闭演示案例 全局关闭
     * @throws IOException 抛出异常
     */
    @Test
    public void settingCacheEnabledFalse () throws IOException {
        String resource = "mybatis-config-cache-enabled-false.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserInfoMapperCache mapper = sqlSession.getMapper(UserInfoMapperCache.class);
            UserInfo userInfo = mapper.getUserInfo(1);
            System.out.println(userInfo);
        }

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserInfoMapperCache mapper = sqlSession.getMapper(UserInfoMapperCache.class);
            UserInfo userInfo = mapper.getUserInfo(1);
            System.out.println(userInfo);
        }
    }

    /**
     * 缓存关闭演示案例， use-cache = false 的方式。
     * @throws IOException 抛出异常
     */
    @Test
    public void settingCacheEnabledUseCacheFalse () throws IOException {
        String resource = "mybatis-config-cache-enabled-use-cache-false.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserInfoMapperCache mapper = sqlSession.getMapper(UserInfoMapperCache.class);
            UserInfo userInfo = mapper.getUserInfo(1);
            System.out.println(userInfo);
        }
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserInfoMapperCache mapper = sqlSession.getMapper(UserInfoMapperCache.class);
            UserInfo userInfo = mapper.getUserInfo(1);
            System.out.println(userInfo);
        }
    }

    /**
     * 缓存开启演示案例，注解版
     * @throws IOException 抛出异常
     */
    @Test
    public void settingCacheEnabledAnnotation () throws IOException {
        String resource = "mybatis-config-cache-enabled-annotation.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserInfoMapperAnnotation mapper = sqlSession.getMapper(UserInfoMapperAnnotation.class);
            UserInfo userInfo = mapper.getUserInfo(2);
            System.out.println(userInfo);
        }
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserInfoMapperAnnotation mapper = sqlSession.getMapper(UserInfoMapperAnnotation.class);
            UserInfo userInfo = mapper.getUserInfo(2);
            System.out.println(userInfo);
        }
    }

}
