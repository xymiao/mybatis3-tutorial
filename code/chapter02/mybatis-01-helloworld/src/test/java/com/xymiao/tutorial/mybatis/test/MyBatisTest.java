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

public class MyBatisTest {
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
}
