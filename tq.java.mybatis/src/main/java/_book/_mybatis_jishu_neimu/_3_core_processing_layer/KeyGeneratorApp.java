package _book._mybatis_jishu_neimu._3_core_processing_layer;

import _book._mybatis_jishu_neimu._2_basic_support_layer._mapper_interface_xml_combine.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 734070824@qq.com
 * @date 2018/11/9 17:33
 */
public class KeyGeneratorApp {

    public static void main(String[] args) throws IOException {
        String resource = "_book/_mybatis_jishu_neimu/_2_basic_support_layer/_mapper_interface_xml_combine/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //加载 mybatis-config.xml 文件, 并创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //结果映射
        //不使用接口
        Student tmp = new Student();
        tmp.setStudentName("student");
        tmp.setStudentAge(123);
        tmp.setStudentPhone("123123");
        sqlSession.insert(
                "_book._mybatis_jishu_neimu._2_basic_support_layer." +
                        "_mapper_interface_xml_combine.StudentDao.insertOneStudent", tmp);
        sqlSession.commit();

    }
}
