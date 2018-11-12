package _book._mybatis_jishu_neimu._2_basic_support_layer._mapper_interface_xml_combine;

import _book._mybatis_jishu_neimu._1_introduction.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 734070824@qq.com
 * @date 2018/11/9 17:33
 */
public class StudentApp {

    public static void main(String[] args) throws IOException {
        String resource = "_book/_mybatis_jishu_neimu/_2_basic_support_layer/_mapper_interface_xml_combine/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //加载 mybatis-config.xml 文件, 并创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //结果映射
        //不使用接口
//        Student student = sqlSession.selectOne("1.selectStudentById", 1);

        StudentDao mapper = sqlSession.getMapper(StudentDao.class);

        Student student = mapper.selectStudentById(1);

        System.err.println(student);
        System.err.println(mapper.selectStudentById(1));
    }
}
