package com.lagou.test;


import com.lagou.dao.UserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
      /*  User user2 = sqlSession.selectOne("user.selectOne", user);

        System.out.println(user2);*/

       /* List<User> users = sqlSession.selectList("user.selectList");
        for (User user1 : users) {
            System.out.println(user1);
        }*/

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        /*List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }*/
        User user2 = userDao.findByCondition(user);
        System.out.println(user2.getUsername());


    }

    /**
     * 测试添加用户
     */
    @Test
    public void testInsertUser() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(2);
        user.setUsername("里斯");
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        int i = userDao.insertUser(user);
        System.out.println(i);
    }

    /**
     * 测试修改用户
     */
    @Test
    public void testUpdateUser() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(2);
        user.setUsername("李四");
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        int i = userDao.updateUser(user);
        System.out.println(i);
    }
    /**
     * 测试删除用户
     */
    @Test
    public void testDeleteUser() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setId(2);
        int i = userDao.deleteUserById(user);
        System.out.println(i);
    }

}
