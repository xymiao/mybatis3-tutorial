package com.xymiao.tutorial.mybatis.test;

import com.xymiao.tutorial.mybatis.mapper.HelloMapper;
import com.xymiao.tutorial.mybatis.pojo.Hello;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisXmlTest {
    @Test
    public void testConnect() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        HelloMapper mapper = sqlSession.getMapper(HelloMapper.class);
        Hello hello = mapper.getHelloInfo(1);
        System.out.println(hello.getDescr());
        sqlSession.close();
    }
    @Test
    public void testSayHello() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try( SqlSession sqlSession = sqlSessionFactory.openSession();) {
            String statement = "com.xymiao.tutorial.mybatis.mapper.HelloMapper.getHelloInfo";
            Hello hello =  sqlSession.selectOne(statement, 1);
            System.out.println(hello.getDescr());
        }
    }

    @Test
    public void testConnectUrlNet() throws IOException {
        String resource = "mybatis-config-url-net.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        HelloMapper mapper = sqlSession.getMapper(HelloMapper.class);
        Hello hello = mapper.getHelloInfo(1);
        System.out.println(hello.getDescr());
        sqlSession.close();
    }

    @Test
    public void testConnectUrlLocal() throws IOException {
        String resource = "mybatis-config-url-local.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        HelloMapper mapper = sqlSession.getMapper(HelloMapper.class);
        Hello hello = mapper.getHelloInfo(1);
        System.out.println(hello.getDescr());
        sqlSession.close();
    }

    @Test
    public void testConnectPackage() throws IOException {
        String resource = "mybatis-config-package.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        HelloMapper mapper = sqlSession.getMapper(HelloMapper.class);
        Hello hello = mapper.getHelloInfo(1);
        System.out.println(hello.getDescr());
        sqlSession.close();
    }
}
