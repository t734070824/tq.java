package _book._mybatis_jishu_neimu._1_introduction;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 流程
 * @author 734070824@qq.com
 * @date 2018/11/7 10:33
 */
public class App {

    public static void main(String[] args) throws IOException {
        String resource = "_book/_mybatis_jishu_neimu/_1_introduction/mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //加载 mybatis-config.xml 文件, 并创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("id",1);
        //结果映射
        Blog blog = sqlSession.selectOne("_book._mybatis_jishu_neimu._1_introduction.BlogMapper.selectBlogDetail", parameter);
        System.err.println(blog);

    }
}
