package com.xymiao.tutorial.mybatis.test;

import com.xymiao.tutorial.mybatis.mapper.DualMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyBatisTest {
    /**
     * resource 资源配置的方式
     * @throws IOException 抛出异常
     */
    @Test
    public void propertiesTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

       try(SqlSession sqlSession = sqlSessionFactory.openSession()){
           DualMapper mapper = sqlSession.getMapper(DualMapper.class);
           String currDate = mapper.getCurrDate();
           System.out.println(currDate);
       }
    }

    /**
     * url 配置的方式
     * @throws IOException 抛出异常
     */
    @Test
    public void propertiesUrlTest() throws IOException {
        String resource = "mybatis-config-url.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DualMapper mapper = sqlSession.getMapper(DualMapper.class);
            String currDate = mapper.getCurrDate();
            System.out.println(currDate);
        }
    }

    /**
     * 子元素配置的方式
     * @throws IOException 抛出异常
     */
    @Test
    public void propertiesInTest() throws IOException {
        String resource = "mybatis-config-in.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DualMapper mapper = sqlSession.getMapper(DualMapper.class);
            String currDate = mapper.getCurrDate();
            System.out.println(currDate);
        }
    }

    /**
     * 方法传参的方式
     * @throws IOException 抛出异常
     */
    @Test
    public void propertiesCodeTest() throws IOException {
        String resource = "mybatis-config-code.xml";
        Properties properties = new Properties();
        properties.put("driver", "com.mysql.cj.jdbc.Driver");
        properties.put("url", "jdbc:mysql://192.168.2.20:3306/mybatis_db");
        properties.put("username", "root");
        properties.put("password", "123456");
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DualMapper mapper = sqlSession.getMapper(DualMapper.class);
            String currDate = mapper.getCurrDate();
            System.out.println(currDate);
        }
    }

    /**
     * 使用错误的地址方式，进行测试几个配置文件的作用域。
     * @throws IOException 抛出异常
     */
    @Test
    public void propertiesPriorityTest() throws IOException {
        String resource = "mybatis-config-priority.xml";
        Properties properties = new Properties();
        properties.put("url", "jdbc:mysql://192.168.2.20:3306/mybatis_db");
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DualMapper mapper = sqlSession.getMapper(DualMapper.class);
            String currDate = mapper.getCurrDate();
            System.out.println(currDate);
        }
    }

    /**
     * 使用错误的地址方式，进行测试几个配置文件的作用域。
     * @throws IOException 抛出异常
     */
    @Test
    public void propertiesPriority2Test() throws IOException {
        String resource = "mybatis-config-priority.xml";
        Properties properties = new Properties();
        properties.put("url", "jdbc:mysql://192.168.2.20:3306/mybatis_db");
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DualMapper mapper = sqlSession.getMapper(DualMapper.class);
            String currDate = mapper.getCurrDate();
            System.out.println(currDate);
        }
    }

    /**
     * 默认占位符方式
     * @throws IOException 抛出异常
     */
    @Test
    public void propertiesPlaceholderTest() throws IOException {
        String resource = "mybatis-config-placeholder.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DualMapper mapper = sqlSession.getMapper(DualMapper.class);
            String currDate = mapper.getCurrDate();
            System.out.println(currDate);
        }
    }

    /**
     * 自定义的占位符方式
     * @throws IOException 抛出异常
     */
    @Test
    public void propertiesPlaceholderCustomTest() throws IOException {
        String resource = "mybatis-config-placeholder-custom.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DualMapper mapper = sqlSession.getMapper(DualMapper.class);
            String currDate = mapper.getCurrDate();
            System.out.println(currDate);
        }
    }

}
