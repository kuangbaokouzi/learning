package com.entor.mybatisdemo;

import com.entor.mybatisdemo.mapper.UserMapper;
import com.entor.mybatisdemo.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MybatisConfigTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testMybaitsConfig() {

        SqlSession sqlSession = null;
        try {
            //  获取一个回话对象
            sqlSession = sqlSessionFactory.openSession();
            // 在会话中注册Mapper（通过动态代理生成UserMapper的代理对象）
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            System.out.println(userMapper.getClass());

            // 通过注册的Mapper中的方法实现数据库的操作
            Map<String, User> userMap = userMapper.getByIdForMap(1);
            System.out.println(userMap);
            System.out.println(userMapper.getByIdForUser(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }

    @Test
    public void testMybatisInsert() {

        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUsername("老张");
            user.setPassword("123123");
            System.out.println(userMapper.insertUser(user));
            sqlSession.commit();
            System.out.println(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }

    @Test
    public void testMybatisUpdate() {

        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setId(4);
            user.setPassword("131211");
            System.out.println(userMapper.updateUser(user));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }

    @Test
    public void testMybatisDelete() {

        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.deleteUser(6));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }

    @Test
    public void testMybatisFind() {

        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            System.out.println(userMapper.findUser(user));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }

    @Test
    public void testMybatisFindAll() {

        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.findAllUser());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }

    @Test
    public void testMybatisSelectOne() {

        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            User user = sqlSession.selectOne("com.entor.mybatisdemo.mapper.UserMapper.getByIdForUser", 1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }
}
