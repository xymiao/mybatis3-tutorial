package com.xymiao.tutorial.mybatis.test;

import com.xymiao.tutorial.mybatis.mapper.UserInfoMapper;
import com.xymiao.tutorial.mybatis.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 驼峰状态的演示
 */
public class MyBatisSettingsCamelCaseTest {

    /**
     * 开启驼峰配置
     *
     * @throws IOException 抛出异常
     */
    @Test
    public void settingMapUnderscoreToCamelCase() throws IOException {
        String resource = "mybatis-config-camel-case.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
            UserInfo userInfo = mapper.getUserInfo(1);
            System.out.println(userInfo);
        }
    }

    /**
     * 驼峰标识关闭演示案例
     *
     * @throws IOException 抛出异常
     */
    @Test
    public void settingMapUnderscoreToCamelCaseFalse() throws IOException {
        String resource = "mybatis-config-camel-case-false.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
            UserInfo userInfo = mapper.getUserInfo(1); // 第一次获取下划线的值
            System.out.println(userInfo);
            userInfo = mapper.getUserInfoByDb(1);  //使用别名的方式
            System.out.println(userInfo);
        }
    }
}
