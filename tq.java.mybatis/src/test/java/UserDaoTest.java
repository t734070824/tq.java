import _begin_to_learn._dao.UserDao;
import _begin_to_learn._entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserDaoTest {


    //TODO 动态sql
    //TODO 结果集解析
    //TODO 一级 二级 缓存
    //TODO 没有数据库

    @Test
    public void findUserById() {
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user = userMapper.findUserById(1);
        System.err.println(user);
        Assert.assertNotNull("没找到数据", user);
    }


    @Test
    public void findUserById2() {
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user = userMapper.findUserById2(2);
        System.err.println(user);
        Assert.assertNotNull("没找到数据", user);
    }

    @Test
    public void insertUser() {
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user  = new User();
        user.setId(2);
        user.setName("tsssss");
        user.setPassword("123ssssssssss");
        int num = userMapper.insert(user);
        System.err.println(num);
        sqlSession.commit();
        sqlSession.close();
        Assert.assertNotNull("没找到数据", user);
    }

    @Test
    public void findAllUsers() {
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        List<User> allUsers = userMapper.findAllUsers();
        System.err.println(allUsers);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findAllUsersMap() {
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        Map<Integer, User> allUsers = userMapper.findAllUsersMap();
        System.err.println(allUsers);
        sqlSession.commit();
        sqlSession.close();
    }

    //Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
    private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "configuration.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources
                    .getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

}